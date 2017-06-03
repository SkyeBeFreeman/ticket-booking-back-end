package com.teamid.controller;

import com.teamid.entity.Movie;
import com.teamid.service.CinemaService;
import com.teamid.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wangzf on 2017/6/3.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CinemaService cinemaService;

    @PostMapping(value = "/like/{movieId}")
    public ResponseEntity<?> likeMovie(@PathVariable long movieId) {
        if (movieService.findMovieById(movieId) != null) {
            movieService.likeByMovieId(movieId);
            return new ResponseEntity<>(movieService.findMovieById(movieId), HttpStatus.OK);
        }
        // TODO: 2017/6/3
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/hotmovies/{movieIndex}")
    public ResponseEntity<?> getHotMovies(@PathVariable int movieIndex) {
        if (movieIndex < movieService.getMovieNums()) {
            return new ResponseEntity<>(movieService.findHotMovies(movieIndex), HttpStatus.OK);
        }
        // TODO: 2017/6/3
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/{cinemaId}")
    public ResponseEntity<?> getMovieByCinemaId(@PathVariable long cinemaId) {
        if (cinemaService.findCinemaById(cinemaId) != null) {
            return new ResponseEntity<>(movieService.findMovieByCinemaId(cinemaId), HttpStatus.OK);
        }
        // TODO: 2017/6/3
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/movie/{movieId}")
    public ResponseEntity<?> getMovie(@PathVariable long movieId) {
        Movie movie = movieService.findMovieById(movieId);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        // TODO: 2017/6/3
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
