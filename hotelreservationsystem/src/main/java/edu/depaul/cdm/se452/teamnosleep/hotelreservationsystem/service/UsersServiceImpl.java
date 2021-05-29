package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

  @Autowired
  private UsersRepository repository;

  @Override
  public List<Users> findAll() {
    return repository.findAll();
  }

  @Override
  public Users update(Users user) {
    repository.save(user);
    return user;
  }
}