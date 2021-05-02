package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import java.sql.Date;
import java.time.LocalDate;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "RESERVATIONS")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "START_DT")
    @NotNull
    private LocalDate startDate;

    @Column(name = "END_DT")
    @NotNull
    private LocalDate endDate;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "ROOM_ID")
    private int roomId;

    // @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    // @JoinColumn(name = "user_id")
    // @NotNull
    // private Users userId;

    // @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    // @JoinColumn(name = "room_id")
    // @NotNull
    // private Rooms roomId;
}
