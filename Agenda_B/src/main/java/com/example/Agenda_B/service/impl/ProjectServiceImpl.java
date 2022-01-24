package com.example.Agenda_B.service.impl;

import com.example.Agenda_B.domain.Project;
import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.repository.ProjectRepository;
import com.example.Agenda_B.service.AuthentificationService;
import com.example.Agenda_B.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private AuthentificationService authService;

    @Autowired
    private ProjectRepository projectRepository;


    // Find all projects on database
    @Transactional(readOnly = true)
    public Collection<Project> findAllProjects() {

        return this.projectRepository.findAll();
    }


    // Only a manager can create projects. The projects created by a manager are added to his list of projects
    @Transactional
    public Project createProject(Project project,String username) {

        User currentUser = this.authService.getLoggedInUserInfo(username);

        project.setManager(currentUser);

        return this.projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public List<Project>  findProjectsOfManager(Long managerId) {

        return this.projectRepository.findByManagerUserId(managerId);
    }
}
