package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Rooms {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "room_name")
    private String roomName;

    @NotNull
    private Integer guests;

    @Column(name = "hotel_id")
    @NotNull
    private Integer hotelId;

    @ManyToOne
    @JoinColumn(name = "room_type")
    @NotNull
    private RoomTypes roomTypes;

    @OneToOne(mappedBy = "roomId")
    private Reservations reservations;
}
