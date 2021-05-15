package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Hotels;


public interface HotelsRepository extends JpaRepository<Hotels, Integer>  {
    List<Hotels> findByLocationId(Integer id);
}