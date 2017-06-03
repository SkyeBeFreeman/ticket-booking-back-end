package com.teamid.service;

import com.teamid.dao.MovieDAO;
import com.teamid.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public void likeByMovieId(long movieId) {
        movieDAO.likeByMovieId(movieId);
    }

    @Override
    public List<Movie> findHotMovies(int movieIndex) {
        return movieDAO.findHotMovies(movieIndex);
    }

    @Override
    public List<Movie> findMovieByCinemaId(long cinemaId) {
        return movieDAO.findMovieByCinemaId(cinemaId);
    }

    @Override
    public Movie findMovieById(long movieId) {
        return movieDAO.findMovieById(movieId);
    }

    @Override
    public int getMovieNums() {
        return movieDAO.getMovieNums();
    }

}
