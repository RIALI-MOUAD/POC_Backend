package com.example.Agenda_B.utils;

import com.example.Agenda_B.domain.Project;
import com.example.Agenda_B.domain.Role;
import com.example.Agenda_B.domain.Time;
import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.repository.ProjectRepository;
import com.example.Agenda_B.repository.RoleRepository;
import com.example.Agenda_B.repository.TimeRepository;
import com.example.Agenda_B.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDateTime;

public class LoadDatabase {
    @Bean
    CommandLineRunner initData(ProjectRepository projectRepository, RoleRepository roleRepository,
                               UserRepository userRepository, TimeRepository timeRepository) {
        return new CommandLineRunner() {

            public void run(String... args) throws Exception {
                initRoleTable(roleRepository);
            }
        };
    }

    private void initProjectTable(ProjectRepository projectRepository) {
        Project prj1 = new Project();
        prj1.setTitre("Project Start-up POC");
        prj1.setDesc("Fise 3 Springboot Angular project");
        projectRepository.save(prj1);
    }

    private void initTimeTable(TimeRepository timeRepository) {
        Time time = new Time();
        time.setDateStart(LocalDateTime.now());
        time.setDateEnd(LocalDateTime.now());
        timeRepository.save(time);
    }

    private void initUserTable(UserRepository userRepository) {
        User user = new User();
        user.setUsername("usernameOne");
        user.setPassword("1234567");
        user.setEmail("username@gmail.com");
        user.setFirstname("firstname");
        user.setLastname("lastname");
        user.setCreatedAt(Instant.now());
        userRepository.save(user);
    }

    private void initRoleTable(RoleRepository roleRepository) {
        Role employee = new Role();
        employee.setId(RolesU.EMPLOYEE_ID);
        employee.setLabel(RolesU.EMPLOYEE_LABEL);
        roleRepository.save(employee);

        Role manager = new Role();
        manager.setId(RolesU.MANAGER_ID);
        manager.setLabel(RolesU.MANAGER_LABEL);
        roleRepository.save(manager);


        Role admin = new Role();
        admin.setId(RolesU.ADMIN_ID);
        admin.setLabel(RolesU.ADMIN_LABEL);
        roleRepository.save(admin);

    }
}
