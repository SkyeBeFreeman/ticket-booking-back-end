package com.teamid.dao;

import com.teamid.entity.Schedule;

import java.util.List;
import java.util.Optional;

/**
 * Created by Skye on 2017/6/3.
 */
public interface ScheduleDAO {

    List<Schedule> findSchedulesByCinemaIdAndMovieId(long cinemaId, long movieId);

    Optional<Schedule> findScheduleByScheduleId(long scheduleId);

    List<Schedule> findSchedulesByCinemaId(long cinemaId);

}
