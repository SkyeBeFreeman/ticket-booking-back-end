package com.teamid.entity;

import java.util.List;

/**
 * Created by Wangzf on 2017/6/5.
 */
public class CinemaInfo {

    private long id;
    private String name;
    private String address;
    private float rank;

    private List<Movie> movies;
    private List<Schedule> schedules;

    public CinemaInfo(Cinema cinema, List<Movie> movies, List<Schedule> schedules) {
        this.id = cinema.getId();
        this.name = cinema.getName();
        this.address = cinema.getAddress();
        this.rank = cinema.getRank();

        this.movies = movies;
        this.schedules = schedules;
    }
}
