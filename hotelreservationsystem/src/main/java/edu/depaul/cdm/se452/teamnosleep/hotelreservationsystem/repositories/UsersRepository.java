package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>  {

    @Query("Select u from Users u WHERE u.username = :username")
    public Users getUserByUsername(@Param("username") String username);

}