package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.HotelService;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.LocationServiceImpl;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.UserService;

@Controller
public class SecurityController {

    @Autowired
    private HotelService hotelService;

    @Autowired
	private UserService userService;

    @Autowired
    private LocationServiceImpl locationService;

    @GetMapping("/login")
	public String showLoginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "index";
	}

	@GetMapping("/")
	public String index(Model model
	,@RequestParam(name = "searchterm", required = false) Optional<String> searchTerm) {
		//add locations list
		model.addAttribute("listLocations", locationService.getAllLocations());
		//if user enters search term, return custom hotel list
		if (searchTerm.isPresent()){
			model.addAttribute("listHotels", hotelService.getHotelsBySearchTerm(searchTerm.get()));
		} else {
			//else, return default hotel list
			model.addAttribute("listHotels", hotelService.getAllHotels());
		}
		return "index";
	}

	// Registration Page
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	// Registration Page
	@PostMapping("/process-register")
	public String processRegistration(Users user) {
		userService.saveUserWithDefaultRole(user);
		return "redirect:/register?success";
	}

    // Access Denied Page
	@GetMapping("/access-denied") 
	public String error403() {
		return "access-denied";
	}

}
