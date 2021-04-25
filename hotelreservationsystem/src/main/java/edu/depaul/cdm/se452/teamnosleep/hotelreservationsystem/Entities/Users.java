package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.Entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    @NotBlank(message = "username may not be empty")
    private String username;

    @NotBlank(message = "password may not be empty")
    private String password_hash;

    @NotBlank(message = "first name may not be empty")
    private String first_name;

    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
    private String middle_name;

    @NotBlank(message = "last name may not be empty")
    @Size(min = 2, max = 32, message = "last name must be between 2 and 32 characters long") 
    private String last_name;

    @Email
    @NotBlank(message = "email may not be empty")
    private String email;

    @OneToOne(mappedBy = "userId")
    private Reservations reservation;
}
