package com.example.Agenda_B.controller;

import com.example.Agenda_B.domain.Role;
import com.example.Agenda_B.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH })
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public Iterable<Role> findRoles() {
        return roleService.findAllRoles();
    }
}