package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.UsersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
>>>>>>> upstream/main

@SpringBootApplication
public class HotelreservationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelreservationsystemApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(HotelreservationsystemApplication.class);
/*
	@Bean
    public CommandLineRunner demo(UsersRepository repository) {
        return (args) -> {
            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach((User) -> {
                log.info(User.toString());
            });
            log.info("-------------------------------");
        };
    }
*/
}
