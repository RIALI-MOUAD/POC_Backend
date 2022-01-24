package com.example.Agenda_B.controller;

import com.example.Agenda_B.domain.Time;
import com.example.Agenda_B.dto.TimeRequest;
import com.example.Agenda_B.service.TimeService;
import com.example.Agenda_B.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/times")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH })
public class TimeController {
    @Autowired
    private TimeService timeService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Collection<Time> fetchAllTimes(){
        return timeService.findAllTimes();
    }

    @PostMapping("/")
    public  Time createTime(@RequestBody TimeRequest timeRequest){
        return timeService.createTime(timeRequest);
    }

    @DeleteMapping("/{timeId}")
    public ResponseEntity<Long> deletePost(@PathVariable Long timeId) {

        boolean isRemoved = this.timeService.deleteTime(timeId);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(timeId, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Time> getTimesofUsers(@PathVariable Long userId){
        return timeService.findTimesOfUser(userId);
    }






}
