package com.teamid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Skye on 2017/6/2.
 */

@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long customer_id;

    @Column
    private long partner_id;

    @Column(nullable = false)
    private long customer_ticket_id;

    @Column
    private long partner_ticket_id;

    @Column
    private String message;

    @Column(nullable = false)
    private int status;

    public Order() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(long partner_id) {
        this.partner_id = partner_id;
    }

    public long getCustomer_ticket_id() {
        return customer_ticket_id;
    }

    public void setCustomer_ticket_id(long customer_ticket_id) {
        this.customer_ticket_id = customer_ticket_id;
    }

    public long getPartner_ticket_id() {
        return partner_ticket_id;
    }

    public void setPartner_ticket_id(long partner_ticket_id) {
        this.partner_ticket_id = partner_ticket_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
