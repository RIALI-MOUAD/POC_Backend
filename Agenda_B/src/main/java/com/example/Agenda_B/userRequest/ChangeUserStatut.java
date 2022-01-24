package com.example.Agenda_B.userRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUserStatut {

        private Long userId;
        private Long roleId;

    }