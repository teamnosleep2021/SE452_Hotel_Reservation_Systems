package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rooms;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomsRepository;

@Component
public class RoomsServiceImpl implements RoomsService{

    @Autowired
    private RoomsRepository roomsRepository;

    @Override
    public List<Rooms> getAllRooms(Integer hotelId) {
        return roomsRepository.findByHotelId(hotelId);
    }
    
}
