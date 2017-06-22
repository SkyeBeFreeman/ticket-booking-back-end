package com.teamid.service;

import com.teamid.entity.Cinema;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

public interface CinemaService {

    List<Cinema> findHotCinemas();

    Cinema findCinemaById(long cinemaId);

    List<Cinema> findCinemaByLocation(int location);
}
