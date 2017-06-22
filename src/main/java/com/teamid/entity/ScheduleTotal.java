package com.teamid.entity;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public class ScheduleTotal {

    private long id;

    private long cinemaId;

    private long movieId;

    private int hall;

    private String startTime;

    private String endTime;

    private float price;

    private List<Ticket> tickets;

    public ScheduleTotal(Schedule schedule, List<Ticket> tickets) {
        this.id = schedule.getId();
        this.cinemaId = schedule.getCinemaId();
        this.movieId = schedule.getMovieId();
        this.hall = schedule.getHall();
        this.startTime = schedule.getStartTime().getMonthValue() + "月"
                       + schedule.getStartTime().getDayOfMonth() + "日 "
                       + String.format("%02d", schedule.getStartTime().getHour()) + ":"
                       + String.format("%02d", schedule.getStartTime().getMinute());
        this.endTime = schedule.getEndTime();
        this.price = schedule.getPrice();
        this.tickets = tickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
