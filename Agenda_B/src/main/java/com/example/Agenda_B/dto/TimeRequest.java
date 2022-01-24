package com.example.Agenda_B.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeRequest {

    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private Long projectId;
    private String username;


}