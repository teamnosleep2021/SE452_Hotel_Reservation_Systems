package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Hotels;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelsRepository;

@Component
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelsRepository hotelsRepository;

    @Override
    public List<Hotels> getAllHotels() {
        return hotelsRepository.findAll();
    }
    
}
