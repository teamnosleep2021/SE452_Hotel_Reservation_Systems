package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.UsersRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Logging - trace method
        log.trace("Entering method loadUserByUsername() ");

        // Logging - debug method
        log.debug("Authenticating user with username:" + username);

        Users user = usersRepository.getUserByUsername(username);
        if(user == null) {
            // Logging - error method
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        // Logging - warn method
        log.warn("Testing logging with Spring Boot...");
        
        // Logging - info method
        log.info("User authenticated successfully");
        
        return new UserDetailsImpl(user);
    }
    
}
