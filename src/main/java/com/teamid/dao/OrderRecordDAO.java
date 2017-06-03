package com.teamid.dao;

import com.teamid.entity.OrderRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface OrderRecordDAO {

    boolean add(OrderRecord orderRecord);

    OrderRecord findOrderRecordById(long id);

    List<OrderRecord> findOrderRecodesByCustomer(long cumstomerId);

    boolean updateOrderRecordWithPartnerId(long id, long partnerId);

    boolean updateOrderRecordWithStatus(long id, int status);

    boolean deleteOrderRecordById(long id);

}
