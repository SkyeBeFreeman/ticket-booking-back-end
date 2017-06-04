package com.teamid.dao;

import com.teamid.entity.Movie;
import com.teamid.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class MovieDAOImpl implements MovieDAO {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void likeMovieById(long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        movieRepository.modifyMovieLikesById(movie.getLike() + 1, movieId);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findMovieById(long movieId) {
        return movieRepository.findOne(movieId);
    }

    @Override
    public int getMovieNums() {
        return movieRepository.findAll().size();
    }
}
