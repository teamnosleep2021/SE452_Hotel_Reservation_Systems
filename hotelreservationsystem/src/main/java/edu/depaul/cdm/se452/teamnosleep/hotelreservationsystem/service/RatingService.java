package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RatingRepository;

@Service
public class RatingService {
    
    @Autowired
    private RatingRepository ratingRepository;

    public int findRatingByIT(int id) {
        
        int hotelRatings = ratingRepository.findById(id).get().getHotelRatings();
        return hotelRatings;
    }
}
