package com.teamid.dao;

import com.teamid.entity.Movie;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface MovieDAO {

    void likeByMovieId(long movieId);

    List<Movie> findHotMovies(int movieIndex);

    Movie findMovieById(long movieId);

    int getMovieNums();
}
