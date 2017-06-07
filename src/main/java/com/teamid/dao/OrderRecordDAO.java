package com.teamid.dao;

import com.teamid.entity.OrderRecord;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface OrderRecordDAO {

    boolean add(OrderRecord orderRecord);

    OrderRecord findOrderRecordById(long id);

    List<OrderRecord> findOrderRecodesByCustomerId(long customerId);

    List<OrderRecord> findOrderRecodesByPartnerId(long partnerId);

    OrderRecord findOrderRecordByPartnerTicketId(long partnerTicketId);

    boolean updateOrderRecordWithPartnerId(long id, long partnerId);

    boolean updateOrderRecordWithStatus(long id, int status);

}
