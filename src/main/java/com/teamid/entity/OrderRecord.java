package com.teamid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Skye on 2017/6/2.
 */

@Entity
public class OrderRecord {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long customerId;

    @Column
    private long partnerId;

    @Column(nullable = false)
    private long customerTicketId;

    @Column
    private long partnerTicketId;

    @Column(nullable = false)
    private int status;

    public OrderRecord() {}

    public OrderRecord(long customerId, long partnerId, long customerTicketId, long partnerTicketId, int status) {
        this.customerId = customerId;
        this.partnerId = partnerId;
        this.customerTicketId = customerTicketId;
        this.partnerTicketId = partnerTicketId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public long getCustomerTicketId() {
        return customerTicketId;
    }

    public void setCustomerTicketId(long customerTicketId) {
        this.customerTicketId = customerTicketId;
    }

    public long getPartnerTicketId() {
        return partnerTicketId;
    }

    public void setPartnerTicketId(long partnerTicketId) {
        this.partnerTicketId = partnerTicketId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
