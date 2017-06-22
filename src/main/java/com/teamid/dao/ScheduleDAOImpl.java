package com.teamid.dao;

import com.teamid.entity.Schedule;
import com.teamid.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Optional<Schedule> findScheduleByScheduleId(long scheduleId) {
        return Optional.ofNullable(scheduleRepository.findOne(scheduleId));
    }

    @Override
    public List<Schedule> findSchedulesByCinemaIdAndMovieId(long cinemaId, long movieId) {
        return scheduleRepository.findSchedulesByCinemaIdAndMovieId(cinemaId, movieId);
    }

    @Override
    public List<Schedule> findSchedulesByCinemaId(long cinemaId) {
        return scheduleRepository.findSchedulesByCinemaId(cinemaId);
    }

    @Override
    public List<Schedule> findSchedulesByMovieId(long movieId) {
        return scheduleRepository.findSchedulesByMovieId(movieId);
    }


}
