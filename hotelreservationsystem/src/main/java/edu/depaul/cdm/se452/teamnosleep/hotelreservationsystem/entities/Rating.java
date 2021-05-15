package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hotelRatings")
public class Rating {
    
    @Id
    public String hotelName;
    public double rating;

}
