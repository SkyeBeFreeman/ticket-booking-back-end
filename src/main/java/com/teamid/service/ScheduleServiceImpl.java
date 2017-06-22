package com.teamid.service;

import com.teamid.dao.ScheduleDAO;
import com.teamid.entity.Schedule;
import com.teamid.utils.LocalDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public Optional<Schedule> findScheduleByScheduleId(long scheduleId) {
        return scheduleDAO.findScheduleByScheduleId(scheduleId);
    }

    @Override
    public List<Schedule> findSchedulesByCinemaIdAndMovieId(long cinemaId, long movieId) {
        return scheduleDAO.findSchedulesByCinemaIdAndMovieId(cinemaId, movieId);
    }

    @Override
    public List<Schedule> findSchedulesByCinemaId(long cinemaId) {
        return scheduleDAO.findSchedulesByCinemaId(cinemaId).stream()
                .filter(i -> LocalDateTimeUtils.getDifference(i.getStartTime(), LocalDateTime.now()) >= 0)
                .collect(Collectors.toList());
    }
}
