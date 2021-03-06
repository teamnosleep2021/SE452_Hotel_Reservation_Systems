package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "HotelRating")
public class HotelRating {
    @Id
	private int id;

	private int hotelRatings;

}
