package com.example.Agenda_C.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    public Project(String title, String description, User manager) {
        this.title = title;
        this.description = description;
        this.manager = manager;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
