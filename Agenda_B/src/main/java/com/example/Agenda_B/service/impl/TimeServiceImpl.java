package com.example.Agenda_B.service.impl;

import com.example.Agenda_B.domain.Project;
import com.example.Agenda_B.domain.Time;
import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.dto.TimeRequest;
import com.example.Agenda_B.repository.ProjectRepository;
import com.example.Agenda_B.repository.TimeRepository;
import com.example.Agenda_B.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    @Bean
    private ProjectRepository projectRepository(){
        return new ProjectRepository() {
            @Override
            public List<Project> findByManagerUserId(Long managerId) {
                return null;
            }

            @Override
            public List<Project> findAll() {
                return null;
            }

            @Override
            public List<Project> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Project> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Project> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Project> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Project> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Project> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Project getOne(Long aLong) {
                return null;
            }

            @Override
            public Project getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Project> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Project> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Project> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Project> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Project> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Project entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Project> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Project> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Project> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Project> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Project> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Project, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    };

    @Autowired
    @Bean
    private TimeRepository timeRepository(){
        return new TimeRepository() {
            @Override
            public List<Time> findAllByUserUserIdAndDateOfProject(Long userId, String date) {
                return null;
            }

            @Override
            public Collection<Time> findByUserUserId(Long idUser) {
                return null;
            }

            @Override
            public List<Time> findAll() {
                return null;
            }

            @Override
            public List<Time> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Time> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Time> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Time> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Time> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Time> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Time getOne(Long aLong) {
                return null;
            }

            @Override
            public Time getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Time> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Time> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Time> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Time> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Time> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Time entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Time> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Time> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Time> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Time> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Time> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Time, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    };

    @Autowired
    private AuthentificationServiceImpl authService;


    // Find all time affections of a user
    @Transactional(readOnly = true)
    public Optional<Time> findTimesById(Long id) {

        return this.timeRepository().findById(id);

    }
    // Employees can affect time to a certain project on dashboard
    @Transactional
    public Time createTime(TimeRequest timeRequest) {


        Time time = new Time();

        time.setDateStart(timeRequest.getDateStart());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        time.setDateOfProject(String.valueOf(time.getDateStart().format(formatter)));
        time.setDateEnd(timeRequest.getDateEnd());

        User currentUser = this.authService.getLoggedInUserInfo(timeRequest.getUsername());
        time.setUser(currentUser);

        Project project = this.projectRepository().findById(timeRequest.getProjectId()).orElse(null);
        time.setProject(project);

        return this.timeRepository().save(time);

    }

    public List<Time> getTimeContent(Long userId,String date) {
        // TODO Auto-generated method stub
        return timeRepository().findAllByUserUserIdAndDateOfProject(userId, date);
    }

    // Find all times of a user
    @Override
    public Collection<Time> findTimesOfUser(Long idUser) {

        return this.timeRepository().findByUserUserId(idUser);
    }

    // Find all time affections on database
    @Transactional(readOnly = true)
    public Collection<Time> findAllTimes() {
        return this.timeRepository().findAll();
    }

    @Transactional
    public boolean deleteTime(Long timeId) {
        this.timeRepository().deleteById(timeId);
        return true;
    }

}
