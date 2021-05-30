package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import java.time.LocalDate;
import java.util.NoSuchElementException;

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
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Reservations;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rooms;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.LocationsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.ReservationsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomTypesRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.UsersRepository;
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
	

	@RequestMapping("/hotel-details.html")
	public String hotelDetails(Model model
							  ,@RequestParam(name = "hotelid") Integer hotelId){
		//start
		var hotel = hotelsRepository.findById(hotelId).get();
		var loc = locationsRepository.findById(hotel.getLocationId()).get();

		model.addAttribute("hotelname", hotel.getHotel_name());
		model.addAttribute("address", loc.getAddress());
		model.addAttribute("state", loc.getState());
		model.addAttribute("zip", loc.getPostal_code());
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

	//add attributes
	model.addAttribute("resid", reservationId);
		return "confirmation";
	}

	@GetMapping("/cancellation.html")
	public String cancellation(){
		return "cancellation";
	}

	@RequestMapping("/manage.html")
	public String manage(){
		return "manage";
	}

	@GetMapping("/updated.html")
	public String update(){
		return "updated";
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