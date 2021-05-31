package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.HotelDescription;

public interface HotelDescriptionRepository extends MongoRepository<HotelDescription, Integer> {

}
