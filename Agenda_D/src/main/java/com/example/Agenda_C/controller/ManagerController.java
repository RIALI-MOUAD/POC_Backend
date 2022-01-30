package com.example.Agenda_C.controller;

import com.example.Agenda_C.domain.Project;
import com.example.Agenda_C.domain.User;
import com.example.Agenda_C.dto.ProjetBody;
import com.example.Agenda_C.dto.UpdateRequest;
import com.example.Agenda_C.repository.ProjectRepository;
import com.example.Agenda_C.repository.UserRepository;
import com.example.Agenda_C.service.MyUserDetails;
import com.example.Agenda_C.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/manager")
public class ManagerController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserService userService;


    @PostMapping("/create-projet")
    public Project createProjet(@RequestBody ProjetBody projetBody){
        User manager = userService.getloggedUser();
        Project project = new Project(
                projetBody.getTitle(),
                projetBody.getDescription(),
                manager
        );
        projectRepository.save(project);
        return project;
    }

    @GetMapping("/users-of-manager")
    public List<User> displayUsers(){
        User manager= userService.getloggedUser();
        List<User> users = userRepository.findByManagerId(manager.getId());
        return users;
    }

    @PatchMapping("/edit-profile/")
    public User updateProfile(@RequestBody UpdateRequest New_user){
        User user = userService.getloggedUser();
        user.setFirstname(New_user.getFirstname());
        user.setLastname(New_user.getLastname());
        //user.setEmail(New_user.getEmail());
        user.setFullname(New_user.getFullname());
        return userRepository.save(user);
    }
}
