package com.example.Agenda_B.repository;

import com.example.Agenda_B.domain.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepositoy extends JpaRepository<VerificationToken,Long> {
    Optional<VerificationToken> findByToken(String token);
}
