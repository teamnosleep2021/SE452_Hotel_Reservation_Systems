package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelDescriptionRepository;

@Service
public class HotelDescriptionService {
    @Autowired
    private HotelDescriptionRepository hotelDescriptionRepository;

    public String findDescriptionByIT(int id) {
        
        String hotelDesc = hotelDescriptionRepository.findById(id).get().getHotelDescription();
        return hotelDesc;
    }
}
