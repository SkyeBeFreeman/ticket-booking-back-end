package com.teamid.controller;

import com.teamid.service.CinemaService;
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

    @GetMapping(value = "/hotcinemas")
    public ResponseEntity<?> getHotCinemas() {
        return new ResponseEntity<>(cinemaService.findHotCinemas(), HttpStatus.OK);
    }

    @GetMapping(value = "/location/{location}")
    public ResponseEntity<?> getCinemasByLocation(@PathVariable int location) {
        return new ResponseEntity<>(cinemaService.findCinemaByLocation(location), HttpStatus.OK);
    }
}
