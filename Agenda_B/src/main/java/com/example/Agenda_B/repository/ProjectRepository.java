package com.example.Agenda_B.repository;

import com.example.Agenda_B.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByManagerUserId(Long managerId);
}
