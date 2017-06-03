package com.teamid.service;

import com.teamid.dao.MovieDAO;
import com.teamid.dao.ScheduleDAO;
import com.teamid.entity.Movie;
import com.teamid.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

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
        List<Schedule> schedules  = scheduleDAO.findSchedulesByCinemaId(cinemaId);
        List<Movie> movies = new ArrayList<>();
        for (Schedule schedule : schedules) {
            movies.add(movieDAO.findMovieById(schedule.getMovieId()));
        }
        return movies;
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
