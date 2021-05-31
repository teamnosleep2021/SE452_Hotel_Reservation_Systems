package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Hotels;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Locations;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.LocationsRepository;

@Component
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelsRepository hotelsRepository;

    @Autowired
    private LocationsRepository locationsRepository;

    @Override
    public List<Hotels> getAllHotels() {
        return hotelsRepository.findAll();
    }

    public List<Hotels> getHotelsBySearchTerm(String searchTerm) {
        List<Integer> locIds = new ArrayList<Integer>();
        List<Locations> locs = locationsRepository.findLocationsByMultiParams(searchTerm);
        for (Locations locations : locs) {
            locIds.add(locations.getId());
        }
        return hotelsRepository.findHotelsByLocIds(locIds);
    }
    
}
