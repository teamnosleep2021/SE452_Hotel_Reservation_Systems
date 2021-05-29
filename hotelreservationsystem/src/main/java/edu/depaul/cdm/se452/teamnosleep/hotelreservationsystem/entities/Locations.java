package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
@Table(name = "LOCATIONS")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "address_str")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state_cd")
    private String state;

    @Column(name = "POSTAL_CODE")
    private int postal_code;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "locations")
    private Hotels hotels;
}
