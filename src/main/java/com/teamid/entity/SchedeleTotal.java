package com.teamid.entity;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public class SchedeleTotal {

    private long id;

    private long cinemaId;

    private long movieId;

    private int hall;

    private String startTime;

    private String endTime;

    private float price;

    private List<Ticket> tickets;

    public SchedeleTotal(Schedule schedule, List<Ticket> tickets) {
        this.id = schedule.getId();
        this.cinemaId = schedule.getCinemaId();
        this.movieId = schedule.getMovieId();
        this.hall = schedule.getHall();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.price = schedule.getPrice();
        this.tickets = tickets;
    }
}
