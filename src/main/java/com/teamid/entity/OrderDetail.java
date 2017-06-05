package com.teamid.entity;

import java.time.LocalDateTime;

/**
 * Created by 伟宸 on 2017/6/4.
 */
public class OrderDetail {

    long orderId;
    long customerId;
    long partnerId;
    long customerTicketId;
    long partnerTicketId;

    int orderStatu;

    String movieCnName;
    String movieEnName;

    String startTime;
    String endTime;

    String cinemaName;

    int posX;
    int posY;

    String partnerPhone;

    public long getOrderId() {
        return orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getPartnerId() {
        return partnerId;
    }

    public long getCustomerTicketId() {
        return customerTicketId;
    }

    public long getPartnerTicketId() {
        return partnerTicketId;
    }

    public int getOrderStatus() {
        return orderStatu;
    }

    public String getMovieCnName() {
        return movieCnName;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public void setCustomerTicketId(long customerTicketId) {
        this.customerTicketId = customerTicketId;
    }

    public void setPartnerTicketId(long partnerTicketId) {
        this.partnerTicketId = partnerTicketId;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatu = orderStatus;
    }

    public void setMovieCnName(String movieCnName) {
        this.movieCnName = movieCnName;
    }

    public void setMovieEnName(String movieEnName) {
        this.movieEnName = movieEnName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setCinema(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPartnerPhone(String partnerPhone) {
        this.partnerPhone = partnerPhone;
    }

    public String getMovieEnName() {
        return movieEnName;

    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCinema() {
        return cinemaName;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getPartnerPhone() {
        return partnerPhone;
    }

    public OrderDetail(long orderId, long customerId, long partnerId, long customerTicketId, long partnerTicketId, int orderStatu, String movieCnName, String movieEnName, String startTime, String endTime, String cinemaName, int posX, int posY, String partnerPhone) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.partnerId = partnerId;
        this.customerTicketId = customerTicketId;
        this.partnerTicketId = partnerTicketId;
        this.orderStatu = orderStatu;
        this.movieCnName = movieCnName;
        this.movieEnName = movieEnName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cinemaName = cinemaName;
        this.posX = posX;
        this.posY = posY;
        this.partnerPhone = partnerPhone;
    }
}
