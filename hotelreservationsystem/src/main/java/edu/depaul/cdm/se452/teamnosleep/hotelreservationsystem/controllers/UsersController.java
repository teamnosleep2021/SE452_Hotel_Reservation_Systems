package edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.entities.Users;
import edu.depaul.cdm.se452.teamnosleep.hotelreservationsystem.service.UsersService;

@Controller
public class UsersController {
    
  @Autowired
  private UsersService usersService;

  @RequestMapping("/register")
  public String register(Model model) {
    model.addAttribute("user", new Users());
      return "register";
  }

  @PostMapping("/register")
  public String saveRegistration(@Valid @ModelAttribute("user") Users user, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "/register";
    }
    usersService.update(user);
    return "registration-success";    
  } 
}
