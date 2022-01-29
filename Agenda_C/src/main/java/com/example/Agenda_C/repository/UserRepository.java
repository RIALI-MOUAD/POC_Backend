package com.example.Agenda_C.repository;

import com.example.Agenda_C.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    boolean findByEmail(String email);
}
