package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "default page";
	}

}