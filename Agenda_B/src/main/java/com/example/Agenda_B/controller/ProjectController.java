package com.example.Agenda_B.controller;


import com.example.Agenda_B.domain.Project;
import com.example.Agenda_B.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectController {
    @Autowired
    @Bean
    private final ProjectService projectService(){
        return new ProjectService() {
            @Override
            public Collection<Project> findAllProjects() {
                return null;
            }

            @Override
            public Project createProject(Project project, String username) {
                return null;
            }

            @Override
            public List<Project> findProjectsOfManager(Long managerId) {
                return null;
            }
        };
    };

    @GetMapping("/")
    public Collection<Project> fetchAllProjects(){
        return projectService().findAllProjects();
    }

    @PostMapping("/{username}")
    public Project creteProject(@RequestBody Project project,@PathVariable String username){
        return projectService().createProject(project,username);
    }
}
