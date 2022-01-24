package com.example.Agenda_B.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String label;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
