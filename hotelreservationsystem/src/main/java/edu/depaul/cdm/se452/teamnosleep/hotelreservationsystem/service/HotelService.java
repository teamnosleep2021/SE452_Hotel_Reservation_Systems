package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;


import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Hotels;

public interface HotelService {
    List<Hotels> getAllHotels();
    List<Hotels> getHotelsBySearchTerm(String searchTerm);
}
