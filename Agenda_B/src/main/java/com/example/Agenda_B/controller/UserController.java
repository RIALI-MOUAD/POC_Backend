package com.example.Agenda_B.controller;

import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.service.UserService;
import com.example.Agenda_B.userRequest.ChangeUser;
import com.example.Agenda_B.userRequest.ChangeUserStatut;
import com.example.Agenda_B.userRequest.CreateUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/")
    public List<User> fetchAllActiveUsers(){
        return userService.findActiveUsers();
    }

    @GetMapping("/all")
    public List<User> fetchAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/create/{idUser}")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody CreateUser createUserRequest, @PathVariable Long idUser){
        return userService.createUser(createUserRequest, idUser);
    }

    @PostMapping("/change-role")
    @ResponseStatus(HttpStatus.OK)
    public User changeUserRole(@RequestBody ChangeUserStatut changeUserRoleRequest){
        return userService.changeUserRole(changeUserRoleRequest);
    }

    @PostMapping("/change")
    @ResponseStatus(HttpStatus.OK)
    public User changeAffectationUser(@RequestBody ChangeUser changeUserRequest){
        return userService.changeAffectationForUser(changeUserRequest);
    }

    @PostMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }
    @GetMapping("/disable/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public User disableUser(@PathVariable Long idUser){
        return userService.disableUser(idUser);
    }
    @GetMapping("/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserInfos(@PathVariable Long idUser){
        return userService.findUser(idUser);
    }

    @GetMapping("/manager/{managerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsersOfManager(@PathVariable Long managerId){
        return userService.findUsersofManager(managerId);
    }



}
