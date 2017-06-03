package com.teamid.controller;

import com.teamid.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Skye on 2017/6/3.
 */

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/scheduleinfo")
    public ResponseEntity<?> getScheduleByCinemaIdAndMovieId(long cinemaId, long movieId) {
        return new ResponseEntity<>(scheduleService.findScheduleByCinemaIdAndMovieId(cinemaId, movieId), HttpStatus.OK);
    }

//    @GetMapping(value = "/{scheduleId}")
//    public ResponseEntity<?> getScheduleByScheduleId(@PathVariable long scheduleId) {
//
//    }


}
