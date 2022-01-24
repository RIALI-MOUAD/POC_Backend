package com.example.Agenda_B.service;

import com.example.Agenda_B.domain.Time;
import com.example.Agenda_B.dto.TimeRequest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TimeService {
    public Collection<Time> findAllTimes();


    public Optional<Time> findTimesById(Long id);


    public Time createTime(TimeRequest timeRequest);


    public List<Time> getTimeContent(Long userId, String date);


    public Collection<Time> findTimesOfUser(Long idUser);


    public boolean deleteTime(Long timeId);
}
