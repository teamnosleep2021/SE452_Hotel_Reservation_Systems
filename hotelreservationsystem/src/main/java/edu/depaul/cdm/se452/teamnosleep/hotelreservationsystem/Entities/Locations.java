package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Locations {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "location name may not be empty")
    private String location_name;

    @OneToOne(mappedBy = "locations")
    private Hotels hotels;
}
