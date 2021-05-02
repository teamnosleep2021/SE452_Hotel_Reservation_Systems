package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rating;

public interface ReviewRepository extends MongoRepository<Rating, String> {
    
}
