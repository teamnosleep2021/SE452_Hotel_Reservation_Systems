package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Payments {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_dt")
    private LocalDate expiryDate;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "payment_dt")
    private LocalDate paymentDate;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservations reservation;
}
