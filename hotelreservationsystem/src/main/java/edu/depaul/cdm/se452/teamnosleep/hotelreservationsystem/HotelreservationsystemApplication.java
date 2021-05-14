package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Locations;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Reservations;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.HotelsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.LocationsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.ReservationsRepository;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.UsersRepository;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class HotelreservationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelreservationsystemApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(HotelreservationsystemApplication.class);

    // //search functionality
	//   @Bean
    // public CommandLineRunner find(UsersRepository repository) {
    //     return (args) -> {
    //         // fetch all customers
    //         log.info("Users found with findAll():");
    //         log.info("-------------------------------");
    //         repository.findAll().forEach((User) -> {
    //             log.info(User.toString());
    //         });
    //         log.info("-------------------------------");
    //     };
    // }
    //create functionality
    @Bean
    public CommandLineRunner createUser(UsersRepository repository) {
        return (args) -> {
        // fetch all Course
        log.info("Before James: " + repository.count());
        Users customer = new Users();
        customer.setUsername("jamesbond");
        customer.setEmail("james@bond.uk");
        customer.setFirst_name("James");
        customer.setLast_name("Bond");
        customer.setPassword_hash("password1");
        repository.save(customer);
        log.info("After James: " + repository.count());
        };
    }

    // //update functionality
    // @Bean
    // public CommandLineRunner updateUser(UsersRepository repository) {
    //     return (args) -> {
    //     // fetch all Course
    //     Optional<Users> users = repository.findById((long) 6);
    //     Users updateUser = users.orElse(new Users());
    //     updateUser.setUsername("updated " + updateUser.getUsername());
  
    //     log.info(users.toString());
  
    //     repository.save(updateUser);
    //     log.info("After James: " + repository.count());
    //     };
    // }

    //find all hotels based on location
    // @Bean
    // public CommandLineRunner findHotels(HotelsRepository repository, LocationsRepository locs) {
    //     return (args) -> {
    //         // fetch all customers
    //         log.info("Hotels found:");
    //         log.info("-------------------------------");
    //         Locations loc = locs.findByLocationName("Chicago");
    //         repository.findByLocationId(loc.getId()).forEach((Hotels) -> {
    //           log.info(Hotels.toString());
    //       });
    //         log.info("-------------------------------");
    //     };
    // }

    //create reservation
    @Bean
    public CommandLineRunner createReservation(ReservationsRepository repository) {
        return (args) -> {
        log.info("Before: " + repository.count());
        Reservations res = new Reservations();
        LocalDate start = LocalDate.of(2021, 6, 11);
        LocalDate end = LocalDate.of(2021, 6, 12);
        res.setStartDate(start);
        res.setEndDate(end);
        res.setRoomId(1);
        res.setUserId(1);
        repository.save(res);
        log.info("After: " + repository.count());
        };
    }

    //update functionality
    @Bean
    public CommandLineRunner updateReservations(ReservationsRepository repository) {
        return (args) -> {
        // fetch all Course
        Optional<Reservations> reservation = repository.findById((long) 4);
        Reservations updatedReservation = reservation.orElse(new Reservations());
        updatedReservation.setEndDate(updatedReservation.getEndDate().plusDays(1));
  
        log.info("Updated Res: " + updatedReservation.toString());

        repository.save(updatedReservation);
        log.info("After: " + repository.count());
        };
    }

    //delete functionality
    @Bean
    public CommandLineRunner deleteReservations(ReservationsRepository repository) {
        return (args) -> {
        // fetch all Course
        log.info("Before: " + repository.count());
        Optional<Reservations> reservation = repository.findById((long) 3);
        Reservations deletedReservation = reservation.orElse(new Reservations());
  
        log.info("Deleted Res: " + deletedReservation.toString());

        repository.delete(deletedReservation);
        log.info("After: " + repository.count());
        };
    }
}
