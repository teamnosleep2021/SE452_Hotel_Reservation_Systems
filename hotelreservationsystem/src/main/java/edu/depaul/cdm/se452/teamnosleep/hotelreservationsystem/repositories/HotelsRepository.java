package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Hotels;


public interface HotelsRepository extends JpaRepository<Hotels, Integer>  {
    List<Hotels> findByLocationId(Integer id);
    //@Query("select h from Hotels h where h.warehouse = w.warehouseId AND w.warehouseId=:warehouseId AND sw.skuMaster=:skuMasterId")
    @Query("select h from Hotels h where h.locationId IN :locs")
    List<Hotels> findHotelsByLocIds(@Param("locs") List<Integer> locs);
}