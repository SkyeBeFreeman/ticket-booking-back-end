package com.teamid.controller;

import com.teamid.entity.Movie;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.service.CinemaService;
import com.teamid.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/like/{movieId}")
    public ResponseEntity<?> likeMovie(@PathVariable long movieId) {
        if (movieService.findMovieById(movieId) != null) {
            movieService.likeMovieById(movieId);
            return new ResponseEntity<>(movieService.findMovieById(movieId), HttpStatus.OK);
        }
        throw new NotFoundException("该电影不存在");
    }

    @GetMapping(value = "/hotmovies/{movieIndex}")
    public ResponseEntity<?> getHotMovies(@PathVariable int movieIndex) {
        if (movieIndex < movieService.getMovieNums()) {
            return new ResponseEntity<>(movieService.findHotMovies(movieIndex), HttpStatus.OK);
        }
        throw new NotFoundException("没有更多热门电影了");
    }

    @GetMapping(value = "/cinema/{cinemaId}")
    public ResponseEntity<?> getMoviesByCinemaId(@PathVariable long cinemaId) {
        if (cinemaService.findCinemaById(cinemaId) != null) {
            return new ResponseEntity<>(movieService.findMoviesByCinemaId(cinemaId), HttpStatus.OK);
        }
        throw new NotFoundException("该电影院不存在");
    }

    @GetMapping(value = "/{movieId}")
    public ResponseEntity<?> getMovie(@PathVariable long movieId) {
        Movie movie = movieService.findMovieById(movieId);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        throw new NotFoundException("该电影不存在");
    }
}
