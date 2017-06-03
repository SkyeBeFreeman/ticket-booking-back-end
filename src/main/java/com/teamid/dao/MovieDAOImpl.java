package com.teamid.dao;

import com.teamid.entity.Movie;
import com.teamid.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class MovieDAOImpl implements MovieDAO {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void likeByMovieId(long movieId) {

    }

    @Override
    public List<Movie> findHotMovies(int movieIndex) {
        return null;
    }

    @Override
    public List<Movie> findMovieByCinemaId(long cinemaId) {
        return null;
    }

    @Override
    public Movie findMovieById(long movieId) {
        return null;
    }

    @Override
    public int getMovieNums() {
        return 0;
    }
}
