package com.teamid.dao;

import com.teamid.entity.Cinema;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface CinemaDAO {

    List<Cinema> findAllCinemas();

    Cinema findCinemaById(long cinemaId);
}
