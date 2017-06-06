package com.teamid.repository;

import com.teamid.entity.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface OrderRecordRepository extends JpaRepository<OrderRecord, Long> {

    List<OrderRecord> findOrderRecordsByCustomerId(long customerId);

    List<OrderRecord> findOrderRecordsByPartnerId(long partnerId);

    @Modifying
    @Query(value = "update OrderRecord o set o.partnerId = ?2 where o.id = ?1"
    , nativeQuery = true)
    void modifyOrderRecordWithPartnerId(long id, long parnetId);

    @Modifying
    @Query(value = "update OrderRecord o set o.status = ?2 where o.id = ?1"
    , nativeQuery = true)
    void modifyOrderRecordWithStatus(long id, int status);

}
