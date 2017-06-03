package com.teamid.service;

import com.teamid.dao.OrderRecordDAO;
import com.teamid.entity.OrderRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class OrderRecordServiceImpl implements OrderRecordService {

    @Autowired
    OrderRecordDAO orderRecordDAO;

    @Override
    public boolean add(OrderRecord orderRecord) {
        return orderRecordDAO.add(orderRecord);
    }

    @Override
    public OrderRecord findOrderRecordById(long id) {
        OrderRecord orderRecord = orderRecordDAO.findOrderRecordById(id);
        return orderRecord;
    }

    @Override
    public List<OrderRecord> findOrderRecordsByCustomer(long customerId) {
        List<OrderRecord> orderRecords = orderRecordDAO.findOrderRecodesByCustomer(customerId);
        return orderRecords;
    }

    @Override
    public boolean updateOrderRecordWithPartnerId(long id, long partnerId) {
        return orderRecordDAO.updateOrderRecordWithPartnerId(id, partnerId);
    }

    @Override
    public boolean updateOrderRecordWithStatus(long id, int status) {
        return orderRecordDAO.updateOrderRecordWithStatus(id, status);
    }

    @Override
    public boolean isCustomer(long id, long userId) {
        OrderRecord orderRecord = orderRecordDAO.findOrderRecordById(id);
        if (orderRecord != null && orderRecord.getCustomerId() == userId)
            return true;
        return false;
    }

    @Override
    public boolean isPartner(long id, long userId) {
        OrderRecord orderRecord = orderRecordDAO.findOrderRecordById(id);
        if (orderRecord != null && orderRecord.getPartnerId() == userId)
            return true;
        return false;
    }

}
