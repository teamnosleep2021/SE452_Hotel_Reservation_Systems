package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Hotels;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rooms;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.ReservationsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomTypesRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.HotelService;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.RoomsService;

@Controller
public class MainController {

	@Autowired
    private HotelService hotelService;

	@Autowired
    private RoomsService roomsService;

	@Autowired
	private HotelsRepository hotelsRepository;

	//@Autowired
	//private ReservationsRepository reservationsRepository;

	@Autowired
	private RoomsRepository roomsRepository;

	@Autowired
	private RoomTypesRepository roomTypesRepository;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listHotels", hotelService.getAllHotels());
		return "index";
	}

	@RequestMapping("/register.html")
	public String register() {
		return "register";
	}

	@RequestMapping("/sign-in.html")
	public String signIn() {
		return "sign-in";
	}

	@RequestMapping("/hotel-details.html")
	public String hotelDetails(Model model
							  ,@RequestParam(name = "hotelid") Integer hotelId){
		//start
		var hotel = hotelsRepository.findById(hotelId).get();
		model.addAttribute("hotelname", hotel.getHotel_name());
		var loc = hotel.getLocations();
		model.addAttribute("address", loc.getLocationName());
		model.addAttribute("zip", hotel.getPostal_code());

		model.addAttribute("listRooms", roomsService.getAllRooms(hotel.getId()));
		return "hotel-details";
	}

	@RequestMapping("/book-room.html")
	public String bookRoom(Model model
						  ,@RequestParam(name = "hotelid") Integer hotelId
						  ,@RequestParam(name = "roomid") Integer roomId
						  ){
		int userId = 1;
		try {
			Hotels hotelDetails = hotelsRepository.findById(hotelId).get();
			Rooms roomDetails = roomsRepository.findById(roomId).get();
			//add info to model
			model.addAttribute("userid",userId);
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
}