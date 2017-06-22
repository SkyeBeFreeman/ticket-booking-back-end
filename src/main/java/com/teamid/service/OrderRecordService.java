package com.teamid.service;

import com.teamid.entity.OrderRecord;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface OrderRecordService {

    boolean add(OrderRecord orderRecord);

    OrderRecord findOrderRecordById(long id);

    List<OrderRecord> findOrderRecordsByCustomerId(long customerId);

    List<OrderRecord> findOrderRecordsByPartnerId(long partnerId);

    OrderRecord findOrderRecordByPartnerTicketId(long partnerTicketId);

    boolean updateOrderRecordWithPartnerId(long id, long partnerId);

    boolean updateOrderRecordWithStatus(long id, int status);

    boolean isCustomer(long id, long userId);

    boolean isPartner(long id, long userId);

}
