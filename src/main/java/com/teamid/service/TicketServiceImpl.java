package com.teamid.service;

import com.teamid.dao.TicketDAO;
import com.teamid.entity.Schedule;
import com.teamid.entity.Ticket;
import com.teamid.entity.TicketStatus;
import com.teamid.utils.LocalDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private ScheduleService scheduleService;

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
    public void modifyTicketMessageById(long ticketTd, String message) {
        ticketDAO.modifyTicketMessageById(ticketTd, message);
    }

    @Override
    public boolean checkPartnerTicketExpired(long ticketId) {
        return checkTicket1hExpired(ticketId);
    }

    @Override
    public boolean checkTicketExpired(long ticketId) {

        Ticket ticket = ticketDAO.findTicketById(ticketId);
        long scheduleId = ticket.getScheduleId();
        Schedule schedule = scheduleService.findScheduleByScheduleId(scheduleId).get();
        long gap = LocalDateTimeUtils.getDifference(schedule.getStartTime(), LocalDateTime.now());

        return gap <= 0;

    }

    @Override
    public boolean checkTicket1hExpired(long ticketId) {

        Ticket ticket = ticketDAO.findTicketById(ticketId);
        long scheduleId = ticket.getScheduleId();
        Schedule schedule = scheduleService.findScheduleByScheduleId(scheduleId).get();
        long gap = LocalDateTimeUtils.getDifference(schedule.getStartTime(), LocalDateTime.now());

        return gap <= 60;

    }


}
