package com.teamid.dao;

import com.teamid.entity.Ticket;
import com.teamid.entity.TicketStatus;
import com.teamid.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void modifyTicketStatusById(long ticketTd, int status) {
        ticketRepository.modifyTicketStatusById(status, ticketTd);
    }

    @Override
    public List<Ticket> findTicketsByScheduleId(long scheduleId) {
        return ticketRepository.findTicketsByScheduleId(scheduleId);
    }

    @Override
    public Ticket findTicketById(long ticketId) {
        return ticketRepository.findOne(ticketId);
    }
}
