package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Locations;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.LocationsRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationsRepository locationsRepository;
    
    @Override
    public List<Locations> getAllLocations() {
        return locationsRepository.findAll();
    }
    
}
