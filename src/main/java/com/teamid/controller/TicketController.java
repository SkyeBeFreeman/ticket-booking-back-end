package com.teamid.controller;

import com.teamid.entity.Ticket;
import com.teamid.entity.TicketStatus;
import com.teamid.service.TicketService;
import com.teamid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Wangzf on 2017/6/3.
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/buy/{ticketId}")
    public ResponseEntity<?> buyTicket(@PathVariable long ticketId, HttpSession session) {
        long userId = (long) session.getAttribute("userId");
        if (userService.findUserById(userId) == null) {
            // TODO: 2017/6/3
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            // TODO: 2017/6/3
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (ticket.getStatus() == TicketStatus.SOLD.ordinal()) {
            // TODO: 2017/6/3
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        ticketService.buyTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
