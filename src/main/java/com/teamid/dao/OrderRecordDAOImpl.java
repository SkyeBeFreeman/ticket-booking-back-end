package com.teamid.dao;

import com.teamid.repository.OrderRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class OrderRecordDAOImpl implements OrderRecordDAO {

    @Autowired
    private OrderRecordRepository orderRecordRepository;

}
