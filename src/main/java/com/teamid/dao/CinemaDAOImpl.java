package com.teamid.dao;

import com.teamid.entity.Cinema;
import com.teamid.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class CinemaDAOImpl implements CinemaDAO {

    private static final int HOT_CINEMAS_NUM = 10;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> findHotCinemas() {
        List<Cinema> cinemas = cinemaRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "rank")));
        List<Cinema> res = new ArrayList<>();
        for (int i = 0; i < HOT_CINEMAS_NUM; i++) {
            res.add(cinemas.get(i));
        }
        return res;
    }

    @Override
    public Cinema findCinemaById(long cinemaId) {
        return cinemaRepository.findOne(cinemaId);
    }
}
