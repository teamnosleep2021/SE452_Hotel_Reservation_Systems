package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.HotelService;

@Controller
public class MainController {

	@Autowired
    private HotelService hotelService;

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
}