package com.teamid.controller;

import com.teamid.entity.Ticket;
import com.teamid.entity.TicketStatus;
import com.teamid.entity.exception.ForbiddenException;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.entity.exception.UnauthorizedException;
import com.teamid.service.TicketService;
import com.teamid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/buy/{ticketId}")
    public ResponseEntity<?> buyTicket(@PathVariable long ticketId, HttpSession session) {
        Object obj = session.getAttribute("userId");
        if (obj == null) {
            throw new UnauthorizedException("Please login first");
        }
        long userId = (long) obj;
        if (userService.findUserById(userId) == null) {
            throw new NotFoundException("User not found");
        }
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            throw new NotFoundException("Ticket not found");
        }
        if (ticket.getStatus() == TicketStatus.SOLD.ordinal()) {
            throw new ForbiddenException("The ticket has been sold");
        }

        ticketService.buyTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
