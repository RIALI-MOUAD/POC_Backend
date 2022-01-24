package com.example.Agenda_B.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestController {
    @GetMapping("/")
    public String test(){
        System.out.println("Test");
        return "Test";
    }

}
