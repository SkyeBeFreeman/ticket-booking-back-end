package com.teamid.repository;

import com.teamid.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Modifying
    @Query(value = "update ticket t set t.status = ?1 where t.id = ?2", nativeQuery = true)
    void modifyTicketStatusById(int status, long ticketTd);

    List<Ticket> findTicketsByScheduleId(long scheduleId);


    @Modifying
    @Query(value = "update ticket t set t.message = ?1 where t.id = ?2", nativeQuery = true)
    void modifyTicketMessageById(String message, long ticketTd);
}
