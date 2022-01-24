package com.example.Agenda_B.service;

import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.repository.UserRepository;
import com.example.Agenda_B.userRequest.ChangeUser;
import com.example.Agenda_B.userRequest.ChangeUserStatut;
import com.example.Agenda_B.userRequest.CreateUser;

import java.util.List;

public interface UserService {

    public User createUser(CreateUser createUser, Long idUser);

    public List<User> findUsersofManager(Long idUser);

    public User changeUserRole(ChangeUserStatut changeUserStatut);

    public User changeAffectationForUser(ChangeUser changeUser);

    public User findUser(Long idUser);


    public User disableUser(Long idUser) ;

    public List<User> findAll();
    public List<User> findActiveUsers();


    public User editUser(User user);
}
