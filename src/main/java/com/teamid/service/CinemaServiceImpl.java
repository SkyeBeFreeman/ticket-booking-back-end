package com.teamid.service;

import com.teamid.dao.CinemaDAO;
import com.teamid.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDAO cinemaDAO;

    @Override
    public List<Cinema> findHotCinemas() {
        return cinemaDAO.findHotCinemas();
    }

    @Override
    public Cinema findCinemaById(long cinemaId) {
        return cinemaDAO.findCinemaById(cinemaId);
    }
}
