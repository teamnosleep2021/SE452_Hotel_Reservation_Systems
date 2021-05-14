package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "LOCATIONS")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "location name may not be empty")
    @Column(name = "LOCATION_NAME")
    private String locationName;

    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "locations")
    private Hotels hotels;
}
