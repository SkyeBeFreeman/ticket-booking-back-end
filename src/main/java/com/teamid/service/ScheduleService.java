package com.teamid.service;

import com.teamid.entity.Schedule;

import java.util.Optional;

/**
 * Created by Skye on 2017/6/3.
 */
public interface ScheduleService {

    Optional<Schedule> findScheduleByCinemaIdAndMovieId(long cinemaId, long movieId);

}
