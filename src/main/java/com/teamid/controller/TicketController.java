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
            throw new UnauthorizedException("请先登录");
        }
        long userId = (long) obj;
        if (userService.findUserById(userId) == null) {
            throw new NotFoundException("账号不存在");
        }
        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            throw new NotFoundException("该电影票不存在");
        }
        if (ticket.getStatus() == TicketStatus.SOLD.ordinal()) {
            throw new ForbiddenException("这张票已经被买走啦");
        }

        ticketService.buyTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
