package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    @Query("SELECT r FROM Role r where r.roleName = ?1")
    public Role findByRoleName(String roleName);
}
