package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Hotels {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "hotel name may not be empty")
    private String hotel_name;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Locations locations;
}
