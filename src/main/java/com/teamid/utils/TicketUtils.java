package com.teamid.utils;

import com.teamid.entity.Schedule;
import com.teamid.entity.Ticket;
import com.teamid.service.ScheduleService;
import com.teamid.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 伟宸 on 2017/6/4.
 */
public class TicketUtils {

    @Autowired
    static TicketService ticketService;

    @Autowired
    static ScheduleService scheduleService;

    public static boolean checkPartnerTicketExpired(long ticketId) {

        Ticket ticket = ticketService.getTicketById(ticketId);
        long scheduleId = ticket.getScheduleId();
        Schedule schedule = scheduleService.findScheduleByScheduleId(scheduleId).get();
        // TODO

        return false;

    }

    public static boolean checkTicketExpired(long ticketId) {

        Ticket ticket = ticketService.getTicketById(ticketId);
        long scheduleId = ticket.getScheduleId();
        Schedule schedule = scheduleService.findScheduleByScheduleId(scheduleId).get();
        //TODO

        return false;

    }

}
