package com.teamid.service;

import com.teamid.dao.CinemaDAO;
import com.teamid.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    private static final int HOT_CINEMAS_NUM = 10;

    @Autowired
    private CinemaDAO cinemaDAO;

    @Override
    public List<Cinema> findHotCinemas() {
        return cinemaDAO.findAllCinemas().stream().limit(HOT_CINEMAS_NUM).collect(Collectors.toList());
    }

    @Override
    public Cinema findCinemaById(long cinemaId) {
        return cinemaDAO.findCinemaById(cinemaId);
    }
}
