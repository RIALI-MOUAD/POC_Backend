package com.example.Agenda_C.dto;

import lombok.Data;

@Data
public class UpdateGlobal {
    private String firstname;
    private String lastname;
    private String email;
    private boolean enabled;
    private Long managerId;
    private Long roleId;
}
