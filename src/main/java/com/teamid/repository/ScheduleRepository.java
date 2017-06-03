package com.teamid.repository;

import com.teamid.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Skye on 2017/6/3.
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
