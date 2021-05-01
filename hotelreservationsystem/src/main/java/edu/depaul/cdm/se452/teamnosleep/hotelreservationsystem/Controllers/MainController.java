package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String greeting() {
		return "index";
	}

}