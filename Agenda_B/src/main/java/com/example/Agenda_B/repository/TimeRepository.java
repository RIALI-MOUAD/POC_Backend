package com.example.Agenda_B.repository;

import com.example.Agenda_B.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TimeRepository extends JpaRepository<Time,Long> {
    List<Time> findAllByUserUserIdAndDateOfProject(Long userId, String date);

    Collection<Time> findByUserUserId(Long idUser);
}
