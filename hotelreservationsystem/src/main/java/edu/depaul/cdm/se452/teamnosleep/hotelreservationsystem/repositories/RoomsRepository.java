package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Rooms;

public interface RoomsRepository extends JpaRepository<Rooms, Integer>  {
}
