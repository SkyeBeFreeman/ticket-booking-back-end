package com.teamid.controller;

import com.teamid.entity.Cinema;
import com.teamid.entity.CinemaInfo;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.service.CinemaService;
import com.teamid.service.MovieService;
import com.teamid.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wangzf on 2017/6/3.
 */
@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/hotcinemas")
    public ResponseEntity<?> getHotCinemas() {
        return new ResponseEntity<>(cinemaService.findHotCinemas(), HttpStatus.OK);
    }

    @GetMapping(value = "/location/{location}")
    public ResponseEntity<?> getCinemasByLocation(@PathVariable int location) {
        return new ResponseEntity<>(cinemaService.findCinemaByLocation(location), HttpStatus.OK);
    }

    @GetMapping(value = "/{cinemaId}")
    public ResponseEntity<?> getCinemaInfoById(@PathVariable long cinemaId) {
        Cinema cinema = cinemaService.findCinemaById(cinemaId);
        if (cinema != null) {
            return new ResponseEntity<>(new CinemaInfo(cinema, movieService.findMoviesByCinemaId(cinemaId),
                    scheduleService.findSchedulesByCinemaId(cinemaId)), HttpStatus.OK);
        }
        throw new NotFoundException("电影院不存在");
    }

}
