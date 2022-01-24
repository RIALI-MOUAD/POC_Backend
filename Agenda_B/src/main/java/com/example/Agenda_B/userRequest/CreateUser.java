package com.example.Agenda_B.userRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUser {
    private String username;
    private String firstname;
    private String lastname;
    private String fullname;
    private String password;
    private String email;
    private Instant createdAt;
    private Long roleId;
    private Long managerId;
}
