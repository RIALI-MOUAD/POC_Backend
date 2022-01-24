package com.example.Agenda_B.service;

import com.example.Agenda_B.domain.Role;
import com.example.Agenda_B.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    public final RoleRepository roleRepository;

    public Iterable<Role> findAllRoles(){
        return roleRepository.findAll();
    }
}
