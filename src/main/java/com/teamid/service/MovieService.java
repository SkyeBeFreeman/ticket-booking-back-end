package com.teamid.service;

import com.teamid.entity.Movie;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

public interface MovieService {

    void likeByMovieId(long movieId);

    List<Movie> findHotMovies(int movieIndex);

    List<Movie> findMoviesByCinemaId(long cinemaId);

    Movie findMovieById(long movieId);

    int getMovieNums();
}
