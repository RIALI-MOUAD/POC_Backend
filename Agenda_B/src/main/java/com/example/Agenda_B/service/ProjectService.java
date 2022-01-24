package com.example.Agenda_B.service;

import com.example.Agenda_B.domain.Project;

import java.util.Collection;
import java.util.List;

public interface ProjectService {
    public Collection<Project> findAllProjects();

    public Project createProject(Project project, String username);

    public List<Project> findProjectsOfManager(Long managerId);
}
