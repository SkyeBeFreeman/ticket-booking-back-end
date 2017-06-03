package com.teamid.service;

import com.teamid.entity.Cinema;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Override
    public List<Cinema> findHotCinemas() {
        return null;
    }

    @Override
    public Cinema findCinemaById(long cinemaId) {
        return null;
    }
}
