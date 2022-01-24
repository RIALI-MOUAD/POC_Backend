package com.example.Agenda_B.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifEmail {
    private String subject;
    private String recipient;
    private String body;
}