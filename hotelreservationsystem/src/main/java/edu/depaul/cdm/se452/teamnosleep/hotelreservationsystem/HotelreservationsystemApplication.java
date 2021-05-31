package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.HotelRating;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RatingRepository;

@SpringBootApplication
public class HotelreservationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelreservationsystemApplication.class, args);
	}

	// Adding Hotel Ratings Document to our MongoDB Collection - HotelRating 
	@Bean
 	 public CommandLineRunner saveHotelRating(RatingRepository repository) {
    	return (args) -> {
      	
			HotelRating rating1 = new HotelRating();
      		rating1.setId(1);
      		rating1.setHotelRatings(3);
      		repository.save(rating1);

      		HotelRating rating2 = new HotelRating();
      		rating2.setId(2);
      		rating2.setHotelRatings(4);
      		repository.save(rating2);  
      
      		HotelRating rating3 = new HotelRating();
      		rating3.setId(3);
      		rating3.setHotelRatings(5);
      		repository.save(rating3); 
			
			HotelRating rating4 = new HotelRating();
      		rating4.setId(4);
      		rating4.setHotelRatings(2);
      		repository.save(rating4); 

			HotelRating rating5 = new HotelRating();
			rating5.setId(5);
			rating5.setHotelRatings(4);
      		repository.save(rating5);
			  
			HotelRating rating6 = new HotelRating();
			rating6.setId(6);
			rating6.setHotelRatings(5);
			repository.save(rating6);

			HotelRating rating7 = new HotelRating();
			rating7.setId(7);
			rating7.setHotelRatings(5);
			repository.save(rating7);

			HotelRating rating8 = new HotelRating();
			rating8.setId(8);
			rating8.setHotelRatings(3);
			repository.save(rating8);

			HotelRating rating9 = new HotelRating();
			rating9.setId(9);
			rating9.setHotelRatings(2);
			repository.save(rating9);

			HotelRating rating10 = new HotelRating();
			rating10.setId(10);
			rating10.setHotelRatings(5);
			repository.save(rating10);
    	};
  } 
}
