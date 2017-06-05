package com.teamid.service;

import com.teamid.dao.TicketDAO;
import com.teamid.entity.Ticket;
import com.teamid.entity.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public void buyTicket(long ticketTd) {
        ticketDAO.modifyTicketStatusById(ticketTd, TicketStatus.SOLD.ordinal());
    }

    @Override
    public List<Ticket> getTicketsByScheduleId(long scheduleId) {
        return ticketDAO.findTicketsByScheduleId(scheduleId);
    }

    @Override
    public Ticket getTicketById(long ticketId) {
        return ticketDAO.findTicketById(ticketId);
    }

    @Override
    public void modifyTicketStatusById(long ticketTd, int status) {
        ticketDAO.modifyTicketStatusById(ticketTd, status);
    }

    @Override
    public void modifyTicketMessageById(long ticketTd, int status) {
        ticketDAO.modifyTicketMessageById(ticketTd, status);
    }


}
