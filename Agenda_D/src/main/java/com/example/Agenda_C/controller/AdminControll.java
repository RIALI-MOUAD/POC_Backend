package com.example.Agenda_C.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.Agenda_C.domain.Project;
import com.example.Agenda_C.domain.User;
import com.example.Agenda_C.dto.UpdateRequest;
import com.example.Agenda_C.registration.RegistrationRequest;
import com.example.Agenda_C.registration.RegistrationService;
import com.example.Agenda_C.repository.ProjectRepository;
import com.example.Agenda_C.repository.RoleRepository;
import com.example.Agenda_C.repository.UserRepository;
import com.example.Agenda_C.service.UserService;
import com.example.Agenda_C.utils.RolesU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

import static com.example.Agenda_C.utils.RolesU.*;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH })
public class AdminControll {
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProjectRepository projectRepository;


    @PatchMapping("/edit-profile/")
    public User updateProfile(@RequestBody UpdateRequest New_user){
        User user = userService.getloggedUser();
        user.setFirstname(New_user.getFirstname());
        user.setLastname(New_user.getLastname());
        user.setEmail(New_user.getEmail());
        user.setFullname(New_user.getFullname());
        return userRepository.save(user);
    }

    @GetMapping("/all-users")
    public List<User> seeAll(){
        List<User> users = userRepository.findAll();
        return users;
    }
    @GetMapping("/users-manager/{manager_id}")
    public List<User> seeSome(@PathVariable Long manager_id){
        List<User> users = userRepository.findByManagerId(manager_id);
        return users;
    }

    @PatchMapping("/edit-role/{id}")
    public User editRole(@PathVariable Long id,@RequestBody String role){
        User user = userRepository.findById(id).get();
        RolesU rolesU = new RolesU();
        if(user.getRole().getLabel()==EMPLOYEE_LABEL && (role==MANAGER_LABEL || role==ADMIN_LABEL)){
            user.setManager(null);
            user.setRole(roleRepository.findByLabel(role));
            return userRepository.save(user);
        }else if (user.getRole().getLabel()==MANAGER_LABEL && role==ADMIN_LABEL){
            user.setRole(roleRepository.findByLabel(role));
            return userRepository.save(user);
        }else{
            System.out.println("You can not Be Employee Or Manager");
        }
        return user;
    }

    @PostMapping("/disable-user/{id}")
    public User disableUser(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        if(user.getRole().getLabel()==ADMIN_LABEL){
            throw new IllegalStateException("You cannot disable an Admin");
        }
        user.setEnabled(false);
        return userRepository.save(user);
    }

    @PostMapping("/enable-user/{id}")
    public User enableUser(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        user.setEnabled(true);
        return userRepository.save(user);
    }

    @PatchMapping("/change-affec/{id_manager}")
    public Project changeAffectation(@PathVariable Long id_manager,@RequestBody Long project_id){
        User manager = userRepository.findById(id_manager).get();
        Project project = projectRepository.getById(project_id);
        // Affect All affected users to new Manger
        List<User> affectedUsers = userRepository.findByManagerId(project.getManager().getId());
        for(User u:affectedUsers){
            u.setManager(manager);
            userRepository.save(u);
        }
        //Project to new Manager
        project.setManager(manager);
        projectRepository.save(project);
        return project;
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody RegistrationRequest registerRequest) throws Exception {
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
        return userRepository.save(user);
    }
}
