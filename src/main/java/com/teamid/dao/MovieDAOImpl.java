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

    private static final int HOT_MOVIES_NUM = 10;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void likeByMovieId(long movieId) {
        Movie movie = movieRepository.findOne(movieId);
        movieRepository.modifyMovieById(movie.getLike() + 1, movieId);
    }

    @Override
    public List<Movie> findHotMovies(int movieIndex) {
        List<Movie> movies = movieRepository.findAll();
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
    public Movie findMovieById(long movieId) {
        return movieRepository.findOne(movieId);
    }

    @Override
    public int getMovieNums() {
        return movieRepository.findAll().size();
    }
}
