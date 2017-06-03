package com.teamid.repository;

import com.teamid.entity.Cinema;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    List<Cinema> findAll(Sort sort);

    Cinema findOne(Long cinemaId);

    Cinema save(Cinema cinema);

    List<Cinema> save(List<Cinema> cinemas);
}
