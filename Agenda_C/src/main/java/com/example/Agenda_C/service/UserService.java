package com.example.Agenda_C.service;

import com.example.Agenda_C.domain.User;

import java.util.List;

import com.example.Agenda_C.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> fetchAll(){
        return userRepository.findAll();
    }

    public void enableUser(Long id){
        User user = userRepository.getById(id);
        user.setEnabled(true);
        userRepository.save(user);
    }
}
