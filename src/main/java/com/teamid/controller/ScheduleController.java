package com.teamid.controller;

import com.teamid.entity.SchedeleTotal;
import com.teamid.entity.Schedule;
import com.teamid.entity.Ticket;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.service.ScheduleService;
import com.teamid.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Skye on 2017/6/3.
 */

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TicketService ticketService;

    @PostMapping(value = "/scheduleinfo")
    public ResponseEntity<?> getScheduleByCinemaIdAndMovieId(long cinemaId, long movieId) {
        List<Schedule> scheduleList = scheduleService.findSchedulesByCinemaIdAndMovieId(cinemaId, movieId);
        if (scheduleList == null || scheduleList.isEmpty()) {
            throw new NotFoundException("Schedule Not Found");
        }
        return new ResponseEntity<>(scheduleList, HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}")
    public ResponseEntity<?> getScheduleByScheduleId(@PathVariable long scheduleId) {
        Optional<Schedule> temp = scheduleService.findScheduleByScheduleId(scheduleId);
        if (!temp.isPresent()) {
            throw new NotFoundException("Schedule Not Found");
        }
        List<Ticket> ticketList = ticketService.getTicketsByScheduleId(scheduleId);
        if (ticketList == null || ticketList.isEmpty()) {
            throw new NotFoundException("Ticket Not Found");
        }
        SchedeleTotal responseObject = new SchedeleTotal(temp.get(), ticketList);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }


}
