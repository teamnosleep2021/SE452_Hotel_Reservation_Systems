package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "HOTELS")
public class Payment {
    
    @NotNull
    @Column(name = "USER_ID")
    private int user_id;

    @NotNull
    @Column(name = "CARD_TYPE")
    private String card_type;

    @NotNull
    @Column(name = "CARD_HOLDER_NAME")
    private String card_holder_name;

    @NotNull
    @Id
    @Column(name = "CARD_NUMBER")
    private int card_number;

    @NotNull
    @Column(name = "CVV")
    private int cvv;
    
}
