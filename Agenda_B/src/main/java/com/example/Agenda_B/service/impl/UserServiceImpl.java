package com.example.Agenda_B.service.impl;

import com.example.Agenda_B.domain.NotifEmail;
import com.example.Agenda_B.domain.Role;
import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.repository.RoleRepository;
import com.example.Agenda_B.repository.UserRepository;
import com.example.Agenda_B.repository.VerificationTokenRepositoy;
import com.example.Agenda_B.service.MailService;
import com.example.Agenda_B.service.UserService;
import com.example.Agenda_B.userRequest.ChangeUser;
import com.example.Agenda_B.userRequest.ChangeUserStatut;
import com.example.Agenda_B.userRequest.CreateUser;
import com.example.Agenda_B.utils.Helpers;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Agenda_B.utils.Helpers.*;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static com.example.Agenda_B.utils.RolesU.MANAGER_ID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepositoy verificationTokenRepository;

    @Autowired
    private MailService mailService;

    @Override
    public User createUser(CreateUser createUser, Long idUser) {

        // save data's coming from inputs
        User user = new User();
        user.setUsername(createUser.getUsername());
        user.setPassword(passwordEncoder.encode(createUser.getPassword()));
        user.setEmail(createUser.getEmail());
        user.setFirstname(createUser.getFirstname());
        user.setLastname(createUser.getLastname());
        user.setFullname(createUser.getLastname()+" "+createUser.getFirstname());
        user.setCreatedAt(Instant.now());

        // Set the user's role

        Role role = roleRepository.findById(createUser.getRoleId()).get();
        user.setRole(role);

        User currentUser = userRepository.findById(idUser).get();
        if(currentUser.getRole().getLabel().equals("MANAGER"))
            user.setManager(currentUser);

        if(currentUser.getRole().getLabel().equals("ADMIN")) {
            if(createUser.getManagerId()!=null)
            {User manager = userRepository.findById(createUser.getManagerId()).get();
                user.setManager(manager);}
        }

        User savedUser = userRepository.save(user);
        String token = String.valueOf((user));
        mailService.sendMail(new NotifEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to <strong>Agenda</strong>, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8081/api/auth/accountVerification/" + token));
        return savedUser;
    }

    @Override
    public List<User> findUsersofManager(Long idUser) {
        return userRepository.findAllByManagerUserId(idUser);
    }

    @Override
    public User changeUserRole(@NotNull ChangeUserStatut changeUserStatut) {
        User user = userRepository.findById(changeUserStatut.getUserId()).get();

        Role new_Role = roleRepository.getById(changeUserStatut.getRoleId());
        Helpers helpers = new Helpers();
        if(helpers.manager2admin(user,new_Role.getId())){
            List <User> usersOfManager = findUsersofManager(user.getId());
            for(User u: usersOfManager){
                helpers.setNullManager(u,userRepository);
            }
        }
        if(helpers.employee2admin(user, new_Role.getId()) || helpers.employee2manager(user, new_Role.getId())){
            user.setManager(null);
        }
        user.setRole(new_Role);

        return userRepository.save(user);
    }

    @Override
    public User changeAffectationForUser(ChangeUser changeUser) {
        User user = userRepository.findById(changeUser.getUserId()).get();
        User manager = userRepository.findById(changeUser.getManagerId()).get();
        Helpers helpers = new Helpers();
        return helpers.changeAffectationUser(user,manager,userRepository);
    }

    @Override
    public User findUser(Long idUser) {
        return userRepository.findById(idUser).get();
    }

    @Override
    public User disableUser(Long id) {
        User user = userRepository.findById(id).get();
        Helpers helpers = new Helpers();
        return helpers.disableUser(user,userRepository,id);
    }

    @Override
    public List<User> findActiveUsers() {
        return userRepository.findByEnabled(true);
    }

    @Override
    public User editUser(User user) {
        User userOld = userRepository.findById(user.getId()).get();
        Role roleUser = user.getRole();
        // Infos
        userOld.setFirstname(user.getFirstname());
        userOld.setLastname(user.getLastname());
        userOld.setEmail(user.getEmail());
        userOld.setFullname(user.getFullname());
        // Role
        Role new_Role = user.getRole();
        Helpers helpers = new Helpers();
        if(helpers.manager2admin(userOld,new_Role.getId())){
            List <User> usersOfManager = findUsersofManager(userOld.getId());
            for(User u: usersOfManager){
                helpers.setNullManager(u,userRepository);
            }
        }
        if(helpers.employee2admin(userOld, new_Role.getId()) || helpers.employee2manager(userOld, new_Role.getId())){
            userOld.setManager(null);
        }
        userOld.setRole(new_Role);
        Optional<User> manager = userRepository.findById(user.getManager().getId());
        if(user.getManager() != null){
            if(helpers.employeeAndmanager(userOld,manager.get())){
                userOld.setManager(manager.get());
            }
        }
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
