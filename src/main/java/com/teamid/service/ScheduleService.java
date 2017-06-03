package com.teamid.service;

import com.teamid.entity.Schedule;

import java.util.List;
import java.util.Optional;

/**
 * Created by Skye on 2017/6/3.
 */
public interface ScheduleService {

    Optional<Schedule> findScheduleByScheduleId(long scheduleId);

    List<Schedule> findSchedulesByCinemaIdAndMovieId(long cinemaId, long movieId);

}
