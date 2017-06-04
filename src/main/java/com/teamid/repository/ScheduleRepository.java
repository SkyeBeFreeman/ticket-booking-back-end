package com.teamid.repository;

import com.teamid.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findSchedulesByCinemaIdAndMovieId(long cinemaId, long movieId);

    List<Schedule> findSchedulesByCinemaId(long cinemaId);

    List<Schedule> findSchedulesByMovieId(long movieId);

}
