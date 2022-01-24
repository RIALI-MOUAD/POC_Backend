package com.example.Agenda_B.service;

import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.dto.AuthenticationResponse;
import com.example.Agenda_B.dto.LoginRequest;
import com.example.Agenda_B.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthentificationService {
    public User register(RegisterRequest registerRequest);
    public String newVerificationToken(User user);
    public void accountVerification(String token);
    public AuthenticationResponse login(LoginRequest loginRequest);
    public User getLoggedInUserInfo(String username);
}
