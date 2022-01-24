package com.example.Agenda_B.controller;


import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.dto.AuthenticationResponse;
import com.example.Agenda_B.dto.LoginRequest;
import com.example.Agenda_B.dto.RegisterRequest;
import com.example.Agenda_B.service.AuthentificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 120, methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH })
public class registercontroller {
    @Autowired
    public final AuthentificationService authentificationService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody RegisterRequest registerRequest) {
        return authentificationService.register(registerRequest);
    }

    @GetMapping("/accountVerification/{token}")
    @ResponseStatus(HttpStatus.OK)
    public String accountVerification(@PathVariable String token) {
        authentificationService.accountVerification(token);
        return "Account enabled successfully \n";
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authentificationService.login(loginRequest);
    }

    @GetMapping("/info/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User loggedInUser(@PathVariable String username) {
        return authentificationService.getLoggedInUserInfo(username);
    }

}
