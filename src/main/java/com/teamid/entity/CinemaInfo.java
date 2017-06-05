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
    private List<ScheduleBean> schedules;

    public CinemaInfo(Cinema cinema, List<Movie> movies, List<ScheduleBean> schedules) {
        this.id = cinema.getId();
        this.name = cinema.getName();
        this.address = cinema.getAddress();
        this.rank = cinema.getRank();

        this.movies = movies;
        this.schedules = schedules;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<ScheduleBean> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleBean> schedules) {
        this.schedules = schedules;
    }
}
