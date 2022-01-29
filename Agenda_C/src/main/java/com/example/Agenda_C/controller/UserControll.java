package com.example.Agenda_C.controller;

import com.example.Agenda_C.domain.User;
import com.example.Agenda_C.repository.UserRepository;
import com.example.Agenda_C.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserControll {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> fetchAll(){
        return userRepository.findAll();
    }
}
