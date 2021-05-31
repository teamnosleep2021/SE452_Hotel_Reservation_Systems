package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Hotels;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Payment;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Reservations;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rooms;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.LocationsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.PaymentRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.ReservationsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomTypesRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.UsersRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.RatingService;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.RoomTypesService;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.RoomsService;

@Controller
public class MainController {

	@Autowired
    private RoomsService roomsService;

	@Autowired
    private RoomTypesService roomTypesService;

	@Autowired
	private HotelsRepository hotelsRepository;

	@Autowired
	private LocationsRepository locationsRepository;

	@Autowired
	private ReservationsRepository reservationsRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RoomsRepository roomsRepository;

	@Autowired
	private RoomTypesRepository roomTypesRepository;

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private RatingService ratingService;

	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/hotel-details.html")
	public String hotelDetails(Model model
							  ,@RequestParam(name = "hotelid") Integer hotelId){
		//start
		var hotel = hotelsRepository.findById(hotelId).get();
		var loc = locationsRepository.findById(hotel.getLocationId()).get();
		var hotelRating = ratingService.findRatingByIT(hotelId);

		log.info("Hotel ID " +  hotelId + " has a rating of " + hotelRating);

		model.addAttribute("hotelname", hotel.getHotel_name());
		model.addAttribute("address", loc.getAddress());
		model.addAttribute("state", loc.getState());
		model.addAttribute("zip", loc.getPostal_code());
		model.addAttribute("rating", hotelRating);
		model.addAttribute("listRooms", roomsService.getAllRooms(hotel.getId()));
		model.addAttribute("listRoomTypes", roomTypesService.getAllRoomTypes());
		return "hotel-details";
	}

	@RequestMapping("/book-room.html")
	public String bookRoom(Model model
						  ,@RequestParam(name = "roomid") Integer roomId
						  ){
		try {	
			Rooms roomDetails = roomsRepository.findById(roomId).get();
			var hotelId = roomDetails.getHotelId();
			Hotels hotelDetails = hotelsRepository.findById(hotelId).get();
			//add info to model
			model.addAttribute("roomid", roomId);
			model.addAttribute("hotelname",hotelDetails.getHotel_name());
			model.addAttribute("roomtype",roomTypesRepository.findById(roomDetails.getRoomTypeID()).get().getType());
			model.addAttribute("roomnumber",roomDetails.getRoomName());
			model.addAttribute("numberofguests",roomDetails.getGuests());
			Double costPerNight = roomDetails.getCostPerNight();
			Double taxRate = 0.045;
			Double tax = (costPerNight*taxRate);
			Double total = costPerNight + tax;
			model.addAttribute("costpernight","$" + costPerNight);
			model.addAttribute("tax","$" + tax);
			model.addAttribute("total","$" + total);
			var currentDate = LocalDate.now();
			model.addAttribute("checkindate",currentDate);
			model.addAttribute("checkoutdate",currentDate.plusDays(2));
		} catch (NoSuchElementException ex){
			ex.printStackTrace();
		}
		return "book-room";	
	}

	@RequestMapping("/confirmation.html")
	public String confirmation(Model model
	,@RequestParam(name = "resid") Integer reservationId
	,@RequestParam(name = "cardtype") String cardType
	,@RequestParam(name = "cardholdername") String cardHolderName
	,@RequestParam(name = "cardnumber") String cardNumber
	,@RequestParam(name = "cardcvv") String cardCVV
	,@RequestParam(name = "cardexpdt") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate cardExpDate){
	//persist payment
	Payment p = new Payment();
	p.setCard_holder_name(cardHolderName);
	p.setCard_number(cardNumber);
	p.setCvv(cardCVV);
	p.setCard_type(cardType);
	//get user details
	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String userName = userDetails.getUsername();
	int userId = usersRepository.getUserByUsername(userName).getId();
	p.setUser_id(userId);
	p.setExpDt(cardExpDate);
	paymentRepository.save(p);
	//add attributes
	model.addAttribute("resid", reservationId);
	model.addAttribute("payid", p.getId());
		return "confirmation";
	}

	@GetMapping("/cancellation.html")
	public String cancellation(Model model
	,@RequestParam(name = "resid") Long reservationId){
		var res = reservationsRepository.findById(reservationId);
		if (res.isPresent()){
			var r = res.get();
			reservationsRepository.delete(r);
			model.addAttribute("resid", reservationId);
			return "cancellation";
		} else {
			model.addAttribute("errormsg", "Cannot Delete Reservation: Reservation ID not found");
			return "error";
		}
	}

	@RequestMapping("/manage.html")
	public String manage(Model model
	,@RequestParam(name = "bookingID", required = false) Optional<Long> bookingId){

	//return parameterless page (no booking id)
	if (!bookingId.isPresent()){
		return "manage";
	} {
		//add attributes
		model.addAttribute("resid", bookingId.get());

		//get user details
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		int userId = usersRepository.getUserByUsername(userName).getId();

		//logic
		var res = reservationsRepository.findById(bookingId.get());

			if(!res.isPresent()){
				//error out (no reservation found)
				model.addAttribute("errormsg", "No reservation found with ID: " + bookingId.get());
				return "error";
			} else {
				//reservation found
				var r = res.get();
				//check user auth
				boolean userIsAdmin = false;
				if (userDetails != null && userDetails.getAuthorities().stream()
				.anyMatch(a -> a.getAuthority().equals("ADMIN"))){
					userIsAdmin = true;
				}
				//check for userid matches res or is admin
				if ((userId == r.getUserId()) || userIsAdmin){
					//authorized
					model.addAttribute("checkindate", r.getStartDate());
					model.addAttribute("checkoutdate", r.getEndDate());
					Rooms room = roomsRepository.findById(r.getRoomId()).get();
					var hotelId = room.getHotelId();
					var hotel = hotelsRepository.findById(hotelId).get();
					model.addAttribute("hotelname", hotel.getHotel_name());
					var roomType = roomTypesRepository.findById(room.getRoomTypeID()).get();
					model.addAttribute("roomtype", roomType.getType());
					model.addAttribute("numberofguests", room.getGuests());
					//return page
					return "manage";
				} else {
					//unauthorized
					model.addAttribute("errormsg", "User ID does not match for reservation: " + bookingId.get());
					return "error";
				}
			}
		}
	}

	@GetMapping("/updated.html")
	public String update(Model model
	,@RequestParam(name = "resid") Long bookingId
	,@RequestParam(name = "checkindate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate checkInDate
	,@RequestParam(name = "checkoutdate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate checkOutDate){
	var res = reservationsRepository.findById(bookingId);
	if (res.isPresent()){
		var r = res.get();
		model.addAttribute("resid", bookingId);
		r.setStartDate(checkInDate);
		r.setEndDate(checkOutDate);
		reservationsRepository.save(r);
		return "updated";
	} else {
		model.addAttribute("errormsg","Reservation ID not found");
		return "error";
	}
	
	}

	@RequestMapping("/payment.html")
	public String payment(Model model
	,@RequestParam(name = "roomid") Integer roomId
	,@RequestParam(name = "startdt") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate checkInDate
	,@RequestParam(name = "enddt") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate checkOutDate){

	//get user details
	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String userName = userDetails.getUsername();

	//save reservation
	Reservations res = new Reservations();
	res.setRoomId(roomId);
	res.setStartDate(checkInDate);
	res.setEndDate(checkOutDate);
	int userId = usersRepository.getUserByUsername(userName).getId();
	res.setUserId(userId);
	reservationsRepository.save(res);
	//add attributes
	model.addAttribute("resid", res.getId());
		return "payment";
	}
}