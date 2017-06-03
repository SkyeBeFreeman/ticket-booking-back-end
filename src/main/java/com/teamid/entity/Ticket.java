package com.teamid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Skye on 2017/6/2.
 */

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long schedule_id;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private int pos_x;

    @Column(nullable = false)
    private int pos_y;

    public Ticket() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(long schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPos_x() {
        return pos_x;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
}
