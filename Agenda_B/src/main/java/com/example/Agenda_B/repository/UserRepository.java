package com.example.Agenda_B.repository;

import com.example.Agenda_B.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findById(Long id);

    public User findByUsername(String username);

    public List<User> findByEnabled(boolean enabled);


    public List<User> findAllByManagerUserId(Long userId);
}
