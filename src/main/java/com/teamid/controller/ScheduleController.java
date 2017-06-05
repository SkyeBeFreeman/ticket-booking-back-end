package com.teamid.controller;

import com.teamid.entity.ScheduleTotal;
import com.teamid.entity.Schedule;
import com.teamid.entity.Ticket;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.service.ScheduleService;
import com.teamid.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/scheduleinfo")
    public ResponseEntity<?> getScheduleByCinemaIdAndMovieId(long cinemaId, long movieId) {
        List<Schedule> scheduleList = scheduleService.findSchedulesByCinemaIdAndMovieId(cinemaId, movieId);
        if (scheduleList == null || scheduleList.isEmpty()) {
            throw new NotFoundException("没有找到电影和影院对应的档期");
        }
        return new ResponseEntity<>(scheduleList, HttpStatus.OK);
    }

    @GetMapping(value = "/{scheduleId}")
    public ResponseEntity<?> getScheduleByScheduleId(@PathVariable long scheduleId) {
        Optional<Schedule> temp = scheduleService.findScheduleByScheduleId(scheduleId);
        if (!temp.isPresent()) {
            throw new NotFoundException("没有找到对应的档期");
        }
        List<Ticket> ticketList = ticketService.getTicketsByScheduleId(scheduleId);
        if (ticketList == null || ticketList.isEmpty()) {
            throw new NotFoundException("没有票");
        }
        ScheduleTotal responseObject = new ScheduleTotal(temp.get(), ticketList);
        logger.info(responseObject.getStartTime());
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }


}
