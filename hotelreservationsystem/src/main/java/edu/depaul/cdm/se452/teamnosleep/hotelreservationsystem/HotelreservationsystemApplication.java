package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.HotelDescription;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.HotelRating;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelDescriptionRepository;
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

  	// Adding Hotel Descriptions Document to our MongoDB Collection - HotelDescription 
	// Credits to the hotel description - wikipedia and respective hotel's website  
	@Bean
	public CommandLineRunner saveHotelDescription(HotelDescriptionRepository repository) {
	  return (args) -> {
		
		    HotelDescription description1 = new HotelDescription();
		  	description1.setId(1);
			description1.setHotelDescription("The Hilton Chicago also known as Chicago Hilton and Towers is a centrally-located luxury hotel in Chicago, Illinois, United States. The hotel is a Chicago landmark that overlooks Grant Park, Lake Michigan, and the Museum Campus. It is the third-largest hotel in Chicago by number of guest rooms; however, it has the largest total meeting and event space of any Chicago hotel. From its opening in 1927 through 2008, every sitting president of the United States had been housed in the hotel before leaving office.");
			repository.save(description1);

			HotelDescription description2 = new HotelDescription();
		  	description2.setId(2);
			description2.setHotelDescription("The fourth tallest building in the United States, Trump International Hotel & Tower® Chicago served as the inspiration for Dubai's Burj Khalifa, and has quickly become one of the best luxury hotels in Chicago and downtown's most enviable address. Proud to be recognized as a Forbes Travel Guide Four Star Hotel and amongst an elite group of hotels that are Sharecare VERIFIED. Our restaurant, Terrace 16, celebrates vibrant flavors borne of the land. ");
			repository.save(description2);  
	
			HotelDescription description3 = new HotelDescription();
		  	description3.setId(3);
			description3.setHotelDescription("Set in the lively River North neighborhood, Aloft Chicago Downtown River North welcomes guests with superb service, thoughtful amenities and a prime location. Guests enjoy delectable dining at Beatrix Restaurant, easy access to Cubs games at Wrigley Field, sporting events at United Center, theMART, Michigan Ave, high-end shopping and numerous Grant Park attractions, including the Art Institute of Chicago, Museum Campus, and the Shedd Aquarium.");
			repository.save(description3);  
		  
			HotelDescription description4 = new HotelDescription();
			description4.setId(4);
		 	description4.setHotelDescription("Designed for today's discerning traveler, San Jose Marriott is a stylish hotel retreat in a dynamic downtown location. Find your respite in newly renovated hotel accommodations with expansive layouts, plush bedding, ergonomic workstations and views of the San Jose skyline and mountains. Cap a full day of business or sightseeing with a refreshing swim in our hotel's rooftop pool or exhilarating workout in our fitness center. A stylish, high-tech hotel, San Jose Marriott is the perfect home base for your stay in downtown San Jose, CA.");
		  	repository.save(description4);

			HotelDescription description5 = new HotelDescription();
			description5.setId(5);
			description5.setHotelDescription("Fairmont Dallas is ideally located in the heart of the downtown Dallas Arts District, surrounded by an array of fine-dining restaurants, shopping, arts and entertainment. Combining the elegance of classic hospitality with an authentic Texan flair, this iconic luxury hotel is located a few blocks from the Central Business District, less than one mile from the world-famous Sixth Floor Museum at Dealey Plaza, chronicling the life, death and legacy of President John F. Kennedy, walking distance.");
			repository.save(description5);

			HotelDescription description6 = new HotelDescription();
			description6.setId(6);
			description6.setHotelDescription("Comprehensively transformed and perfectly situated, Sheraton Dallas Hotel stands ready to exceed your expectations. We're located in the city's downtown district near American Airlines Center, Fair Park and the diverse Deep Ellum neighborhood. Our hotel's updated dining options include Draft Sports Bar & Lounge, which offers 12 beers on tap and the day's big games. Make yourself comfortable in a beautifully redesigned hotel room with everything you need to relax and work smart, from spacious desks and Wi-Fi to Sheraton Signature Sleep Experience beds.");
			repository.save(description6);

			HotelDescription description7 = new HotelDescription();
			description7.setId(7);
			description7.setHotelDescription("The Bay Street Inn Bed & Breakfast in downtown St Petersburg is a luxury historic boutique inn / B&B. The bed & breakfast comprises nine unique rooms/suites, with three studio apartments in the Carriage House and six luxury rooms in the main house. All are individually styled with high-end furnishings and feature a luxurious king or queen bed and en-suite bathroom, most with jacuzzi tubs, and showers. The Bay Street Inn Bed & Breakfast is situated on the corner of Bay Street NE and 6th Avenue NE, St Petersburg,  and is one block from St Pete's famous Vinoy Hotel and Beach Drive, downtown St Pete's main waterfront dining and entertainment location. It's an easy walk to St Petersburg's Museum of Fine Arts and Dali Museum and the Vinoy and North Shore Parks and Aquatic Complex. ");
			repository.save(description7);

			HotelDescription description8 = new HotelDescription();
			description8.setId(8);
			description8.setHotelDescription("This sister of the Walt Disney World Dolphin Hotel employs the same modern design sensibilities with a nod to Renaissance elegance. Clamshell fountains and graceful twin swans preside over swaying palm trees, verdant lawns and the gleaming shores of Crescent Lake, while a wave motif with a coral-and-aqua color scheme embodies Florida's unique subtropical style.");
			repository.save(description8);

			HotelDescription description9 = new HotelDescription();
			description9.setId(9);
			description9.setHotelDescription("Minutes from USAFA with Rocky Mountain views. We're off I-25, three miles from the United States Air Force Academy and the University of Colorado. Pikes Peak Highway is 20 miles away and many of our rooms have views of the Rocky Mountain range. Your stay includes made-to-order breakfast and our complimentary evening reception. Enjoy our indoor pool, fitness center, and 24-hour market.");
			repository.save(description9);

			HotelDescription description10 = new HotelDescription();
			description10.setId(10);
			description10.setHotelDescription("Restored to reflect its original appearance, this landmark edifice built in 1910 includes original architectural masonry details and an exterior clock reminiscent of 17th Street’s past as the “wall street of the west.” Comfortable and inviting, we’re close to everywhere you want to be, including Coors Field, Mile High Stadium and the Pepsi Center, as well as many local attractions and other event venues. No visit would be complete without a stop in at Harry’s, rated “one of the best places to chill” by the Denver Post.");
			repository.save(description10);  
		};
	} 
}
