package com.teamid.entity;

/**
 * Created by 伟宸 on 2017/6/3.
 */
public class Order {

    long orderId;
    long customerId;
    long partnerId;
    long customerTicketId;
    long partnerTicketId;

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

    public Order(long orderId, long customerId, long partnerId, long customerTicketId, long partnerTicketId) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.partnerId = partnerId;
        this.customerTicketId = customerTicketId;
        this.partnerTicketId = partnerTicketId;
    }
}
