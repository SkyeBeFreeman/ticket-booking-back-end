package com.teamid.dao;

import com.teamid.entity.OrderRecord;
import com.teamid.repository.OrderRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class OrderRecordDAOImpl implements OrderRecordDAO {

    @Autowired
    private OrderRecordRepository orderRecordRepository;

    @Override
    public boolean add(OrderRecord orderRecord) {
        orderRecordRepository.save(orderRecord);
        return true;
    }

    @Override
    public OrderRecord findOrderRecordById(long id) {
        OrderRecord orderRecord = orderRecordRepository.findOne(id);
        return orderRecord;
    }

    @Override
    public List<OrderRecord> findOrderRecodesByCustomer(long cumstomerId) {
        List<OrderRecord> orderRecords = orderRecordRepository.findOrderRecordsByCustomerId(cumstomerId);
        return orderRecords;
    }

    @Override
    public boolean updateOrderRecordWithPartnerId(long id, long partnerId) {
        OrderRecord orderRecord = orderRecordRepository.findOne(id);
        if (orderRecord == null)
            return false;
        orderRecord.setPartnerId(partnerId);
        orderRecordRepository.modifyOrderRecordWithPartnerId(id, partnerId);
        return true;
    }

    @Override
    public boolean updateOrderRecordWithStatus(long id, int status) {
        OrderRecord orderRecord = orderRecordRepository.findOne(id);
        if (orderRecord == null)
            return false;
        orderRecord.setStatus(status);
        orderRecordRepository.modifyOrderRecordWithStatus(id, status);
        return true;
    }

}
