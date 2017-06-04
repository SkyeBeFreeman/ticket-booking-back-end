package com.teamid.service;

import com.teamid.dao.MovieDAO;
import com.teamid.dao.ScheduleDAO;
import com.teamid.entity.Movie;
import com.teamid.entity.Schedule;
import com.teamid.utils.LocalDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private static final int HOT_MOVIES_NUM = 10;

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public void likeMovieById(long movieId) {
        movieDAO.likeMovieById(movieId);
    }

    @Override
    public List<Movie> findHotMovies(int movieIndex) {
        List<Movie> movies = movieDAO.findAllMovies().stream().filter(
                (Movie movie) ->
                    scheduleDAO.findSchedulesByMovieId(movie.getId()).stream().filter(
                            (Schedule schedule) -> LocalDateTimeUtils.getDifference(schedule.getStartTime(), LocalDateTime.now()) > 0
                    ).count() > 0
        ).collect(Collectors.toList());
        movies.sort((Movie movie1, Movie movie2) ->
                (int)((movie2.getRank() + movie2.getLike()) - (movie1.getRank() + movie1.getLike()))
        );

        List<Movie> res = new ArrayList<>();
        if (movieIndex + HOT_MOVIES_NUM <= movies.size()) {
            for (int i = 0; i < HOT_MOVIES_NUM; i++) {
                res.add(movies.get(movieIndex + i));
            }
            return res;
        }
        int num = HOT_MOVIES_NUM;
        for (int i = movieIndex; i < movies.size(); i++, num--) {
            res.add(movies.get(i));
        }
        for (int i = 0; i < num; i++) {
            res.add(movies.get(i));
        }
        return res;
    }

    @Override
    public List<Movie> findMoviesByCinemaId(long cinemaId) {
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
