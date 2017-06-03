package com.teamid.repository;

import com.teamid.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Skye on 2017/6/3.
 */
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
