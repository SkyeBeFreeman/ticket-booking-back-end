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
    private long scheduleId;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private int posX;

    @Column(nullable = false)
    private int posY;
    
    @Column
    private String message;

    public Ticket() {}

    public Ticket(long scheduleId, int posX, int posY) {
        this.scheduleId = scheduleId;
        this.status = TicketStatus.NOT_SOLD_OUT.ordinal();
        this.posX = posX;
        this.posY = posY;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
