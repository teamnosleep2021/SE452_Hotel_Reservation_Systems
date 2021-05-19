package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;


public interface UsersService {
    public List<Users> findAll();

    public Users update(Users user);
  
}
