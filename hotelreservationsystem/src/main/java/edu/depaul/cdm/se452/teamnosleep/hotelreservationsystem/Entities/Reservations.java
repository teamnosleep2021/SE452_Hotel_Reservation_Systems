package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Reservations {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "start_dt")
    @NotNull
    private Date startDate;

    @Column(name = "end_dt")
    @NotNull
    private Date endDate;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private Users userId;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @NotNull
    private Rooms roomId;
}
