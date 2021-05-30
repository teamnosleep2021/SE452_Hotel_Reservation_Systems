package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.RoomTypes;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.RoomTypesRepository;

@Service
public class RoomTypesServiceImpl implements RoomTypesService {

    @Autowired
    private RoomTypesRepository roomTypesRepository;
    
    @Override
    public List<RoomTypes> getAllRoomTypes() {
        return roomTypesRepository.findAll();
    }
    
}
