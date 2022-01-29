package com.example.Agenda_C.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResources {

    @GetMapping("/")
    public String home(){
        return ("<h1>WELCOME</h1>");
    }

    @GetMapping("/user/")
    public String user_home(){
        return ("<h1>WELCOME User</h1>");
    }

    @GetMapping("/admin/")
    public String admin(){
        return ("<h1>WELCOME Admin</h1>");
    }
}
