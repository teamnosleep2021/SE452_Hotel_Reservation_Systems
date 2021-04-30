package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long>  {
}