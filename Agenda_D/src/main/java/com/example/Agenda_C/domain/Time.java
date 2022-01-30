package com.example.Agenda_C.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "time")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime date_start;

    private LocalDateTime date_end;

    private String date_of_project;

    public Time(LocalDateTime date_start,
                LocalDateTime date_end,
                String date_of_project,
                User user, Project project) {
        this.date_start = date_start;
        this.date_end = date_end;
        this.date_of_project = date_of_project;
        this.user = user;
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
