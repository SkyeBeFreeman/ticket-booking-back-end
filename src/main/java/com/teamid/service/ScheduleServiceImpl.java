package com.teamid.service;

import com.teamid.dao.ScheduleDAO;
import com.teamid.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public Optional<Schedule> findScheduleByCinemaIdAndMovieId(long cinemaId, long movieId) {
        return scheduleDAO.findScheduleByCinemaIdAndMovieId(cinemaId, movieId);
    }
}
