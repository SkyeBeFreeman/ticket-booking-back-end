package com.teamid.dao;

import com.teamid.entity.Ticket;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface TicketDAO {

    void buyTicketByTicketId(long ticketTd);

    List<Ticket> findTicketsByScheduleId(long scheduleId);

    Ticket findTicketById(long ticketId);
}
