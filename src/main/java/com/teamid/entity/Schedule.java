package com.teamid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


/**
 * Created by Skye on 2017/6/2.
 */

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long cinemaId;

    @Column(nullable = false)
    private long movieId;

    @Column(nullable = false)
    private int hall;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private String endTime;

    @Column(nullable = false)
    private float price;

    public Schedule() {}

    public Schedule(long cinemaId, long movieId, int hall, LocalDateTime startTime, String endTime, float price) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.hall = hall;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
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
