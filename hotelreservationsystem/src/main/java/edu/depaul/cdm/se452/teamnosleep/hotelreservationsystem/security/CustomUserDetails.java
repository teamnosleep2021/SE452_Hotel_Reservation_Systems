package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Role;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;

public class CustomUserDetails implements UserDetails{

    private Users user;

    public CustomUserDetails(Users user) {
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Fetches all the roles for a given user
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // Iterates through each role
        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return user.getFname() + " " + user.getLname();
    }
    
}
