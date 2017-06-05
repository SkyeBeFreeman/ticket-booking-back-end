package com.teamid.entity;

/**
 * Created by Skye on 2017/6/5.
 */
public class ScheduleForm {

    private long id;

    private long cinemaId;

    private long movieId;

    private int hall;

    private String startTime;

    private String endTime;

    private float price;

    public ScheduleForm(Schedule schedule) {
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
}
