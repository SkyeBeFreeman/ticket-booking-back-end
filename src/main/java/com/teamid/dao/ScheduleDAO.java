package com.teamid.dao;

import com.teamid.entity.Schedule;

import java.util.List;
import java.util.Optional;

/**
 * Created by Skye on 2017/6/3.
 */
public interface ScheduleDAO {

    Optional<Schedule> findScheduleByCinemaIdAndMovieId(long cinemaId, long movieId);

    List<Schedule> findSchedulesByCinemaId(Long cinemaId);

}
