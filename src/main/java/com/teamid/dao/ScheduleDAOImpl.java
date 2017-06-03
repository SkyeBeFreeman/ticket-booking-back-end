package com.teamid.dao;

import com.teamid.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

    @Autowired
    private ScheduleRepository scheduleRepository;

}
