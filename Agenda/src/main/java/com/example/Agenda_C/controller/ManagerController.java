package com.example.Agenda_C.controller;

import com.example.Agenda_C.domain.Project;
import com.example.Agenda_C.domain.Time;
import com.example.Agenda_C.domain.User;
import com.example.Agenda_C.dto.ProjetBody;
import com.example.Agenda_C.dto.UpdateRequest;
import com.example.Agenda_C.registration.RegistrationRequest;
import com.example.Agenda_C.repository.ProjectRepository;
import com.example.Agenda_C.repository.RoleRepository;
import com.example.Agenda_C.repository.TimeRepository;
import com.example.Agenda_C.repository.UserRepository;
import com.example.Agenda_C.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping(path = "/manager/{jwtToken}")
public class ManagerController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //DONE
    @PostMapping("/create-projet")
    public Project createProjet(@RequestBody ProjetBody projetBody,@PathVariable String jwtToken){
        User manager = userService.getloggedUser(jwtToken);
        Project project = new Project(
                projetBody.getTitle(),
                projetBody.getDescription(),
                manager
        );
        projectRepository.save(project);
        return project;
    }

    //DONE
    @GetMapping("/users-of-manager")
    public List<User> displayUsers(@PathVariable String jwtToken){
        User manager= userService.getloggedUser(jwtToken);
        List<User> users = userRepository.findByManagerId(manager.getId());
        return users;
    }

    //Done
    @GetMapping("/projects")
    public List<Project> displayProjects(@PathVariable String jwtToken){
        User currentmanager = userRepository.findByTokenSignature(jwtToken).get();
        List<Project> projects = projectRepository.findByManagerId(currentmanager.getId());
        return projects;
    }

    @PatchMapping("/edit-profile/")
    public User updateProfile(@RequestBody UpdateRequest New_user,@PathVariable String jwtToken){
        User user = userService.getloggedUser(jwtToken);
        user.setFirstname(New_user.getFirstname());
        user.setLastname(New_user.getLastname());
        //user.setEmail(New_user.getEmail());
        user.setFullname(New_user.getFullname());
        return userRepository.save(user);
    }

    @GetMapping("/times-of-users")
    public Hashtable<User, List<Time>> seeTimesUsers(@PathVariable String jwtToken){
        User manager = userService.getloggedUser(jwtToken);
        List<User> users= userRepository.findByManagerId(manager.getId());
        Hashtable<User, List<Time>> myAnnuaire = new Hashtable<User,List<Time>>();
        for(User u:users){
            List<Time> timeOfUser = timeRepository.findAllByUserId(u.getId());
            myAnnuaire.put(u,timeOfUser);
        }

        return myAnnuaire;
    }

    // DONE
    @PostMapping("/add-user")
    public User addUser(@RequestBody RegistrationRequest registerRequest,
                        @PathVariable String jwtToken) throws Exception {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setFirstname(registerRequest.getFirstname());
        user.setLastname(registerRequest.getLastname());
        user.setFullname(registerRequest.getLastname()+" "+registerRequest.getFirstname());
        user.setRole(roleRepository.findById(registerRequest.getRoleId()).get());
        user.setEnabled(true);
        user.setCreatedAt(Instant.now());
        User manager = userRepository.findByTokenSignature(jwtToken).get();
        user.setManager(manager);
        return userRepository.save(user);
    }
}
