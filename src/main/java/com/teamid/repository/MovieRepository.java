package com.teamid.repository;

import com.teamid.entity.Movie;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Modifying
    @Query(value = "update movie m set m.likes = ?1 where m.id = ?2", nativeQuery = true)
    void modifyMovieById(long likes, long movieId);

    List<Movie> findMovieByCinemaId(long cinemaId);

    List<Movie> save(List<Movie> movies);
}
