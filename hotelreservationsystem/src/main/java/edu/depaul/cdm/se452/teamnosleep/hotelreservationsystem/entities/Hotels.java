package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import javax.persistence.CascadeType;
// import javax.persistence.CascadeType;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;
// import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "HOTELS")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @NotBlank(message = "hotel name may not be empty")
    @Column(name = "HOTEL_NAME")
    private String hotel_name;

    @Column(name = "LOCATION_ID")
    private int locationId;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Locations locations;
}
