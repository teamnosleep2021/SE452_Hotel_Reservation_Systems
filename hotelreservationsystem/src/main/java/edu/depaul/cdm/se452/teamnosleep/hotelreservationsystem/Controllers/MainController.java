package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

}