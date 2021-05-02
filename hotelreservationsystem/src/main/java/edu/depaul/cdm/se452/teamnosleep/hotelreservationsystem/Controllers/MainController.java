package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rating;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.ReviewRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired
	private ReviewRepository reviewRepository;
	@RequestMapping("/")
	public String index() {
		return "default page";
	}

	@RequestMapping("/")
	public List<Rating> testMongo(){
		var rating = new Rating();
		rating.hotelName="Hilton Chicago";
		rating.rating=4;
		reviewRepository.save(rating);

		var rating2 = new Rating();
		rating2.hotelName="Trump International Hotel";
		rating2.rating=5;
		reviewRepository.save(rating2);

		var rating3 = new Rating();
		rating3.hotelName="The Aloft";
		rating3.rating=4.5;
		reviewRepository.save(rating3);

		var rating4 = new Rating();
		rating4.hotelName="San Jose Marriott";
		rating4.rating=4.3;
		reviewRepository.save(rating4);

		var rating5 = new Rating();
		rating5.hotelName="Fairmont Dallas";
		rating5.rating=5;
		reviewRepository.save(rating5);

		var rating6 = new Rating();
		rating6.hotelName="Sheraton Dallas Hotel";
		rating6.rating=4.1;
		reviewRepository.save(rating6);

		var rating7 = new Rating();
		rating7.hotelName="Bay Street Inn";
		rating7.rating=4.5;
		reviewRepository.save(rating7);

		var rating8 = new Rating();
		rating8.hotelName="Walt Disney World Swan";
		rating8.rating=4.8;
		reviewRepository.save(rating8);

		var rating9 = new Rating();
		rating9.hotelName="Embassy Suites Colorado";
		rating9.rating=4.2;
		reviewRepository.save(rating9);

		var rating10 = new Rating();
		rating10.hotelName="Magnolia Hotel Denver";
		rating10.rating=4.7;
		reviewRepository.save(rating10);

		return reviewRepository.findAll();

	}

}