package com.example.Agenda_C.service;

import com.example.Agenda_C.domain.Role;
import com.example.Agenda_C.domain.User;

import java.util.List;
import java.util.Optional;

import com.example.Agenda_C.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public User editProfile(User user) {
        User userOld = userRepository.findById(user.getId()).get();
        Role roleUser = user.getRole();
        // Infos
        userOld.setFirstname(user.getFirstname());
        userOld.setLastname(user.getLastname());
        userOld.setEmail(user.getEmail());
        userOld.setFullname(user.getFullname());
        return userRepository.save(user);
    }

    public User getloggedUser(){
        MyUserDetails currentUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        User currentuser = userRepository.findByUsername(currentUserDetails.getUsername()).get();
        return currentuser;
    }
}
