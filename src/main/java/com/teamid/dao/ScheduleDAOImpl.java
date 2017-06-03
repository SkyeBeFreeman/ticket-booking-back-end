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
    public Optional<Schedule> findScheduleByCinemaIdAndMovieId(long cinemaId, long movieId) {
        return Optional.ofNullable(scheduleRepository.findScheduleByCinemaIdAndMovieId(cinemaId, movieId));
    }

    @Override
    public List<Schedule> findSchedulesByCinemaId(Long cinemaId) {
        return scheduleRepository.findSchedulesByCinemaId(cinemaId);
    }
}
