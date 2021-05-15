package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table( name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "USERNAME", unique = true)
    @NotBlank(message = "username may not be empty")
    private String username;

    @Column(name = "PASSWORD_HASH")
    @NotBlank(message = "password may not be empty")
    private String password_hash;

    @Column(name = "FIRST_NAME")
    @NotBlank(message = "first name may not be empty")
    private String first_name;

    @Column(name = "MIDDLE_NAME")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long") 
    private String middle_name;

    @Column(name = "LAST_NAME")
    @NotBlank(message = "last name may not be empty")
    @Size(min = 2, max = 32, message = "last name must be between 2 and 32 characters long") 
    private String last_name;

    @Email
    @Column(name = "EMAIL")
    @NotBlank(message = "email may not be empty")
    private String email;

    // @OneToOne(mappedBy = "userId")
    // private Reservations reservation;
}
