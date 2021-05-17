package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rooms;

public interface RoomsService {
    List<Rooms> getAllRooms(Integer hotelId);
}
