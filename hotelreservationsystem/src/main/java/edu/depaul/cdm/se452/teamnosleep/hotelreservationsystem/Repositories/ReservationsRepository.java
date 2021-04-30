package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Long>  {
}