package com.teamid.controller;

import com.teamid.entity.*;
import com.teamid.entity.exception.NotAcceptableException;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.service.OrderRecordService;
import com.teamid.service.TicketService;
import com.teamid.service.UserService;
import com.teamid.utils.LoginUtils;
import com.teamid.utils.TicketUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 伟宸 on 2017/6/3.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderRecordService orderRecordService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(long customerTicketId, long partnerTicketId, HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        if (ticketService.getTicketById(customerTicketId) == null
                || ticketService.getTicketById(partnerTicketId) == null)
            throw new NotFoundException("Ticket id not found");


        User customer = userService.findUserById(userId);

        if (customer == null)
            throw new NotFoundException("User not found");

        if (TicketUtils.checkTicketExpired(customerTicketId))
            throw new NotAcceptableException("Ticket expires");
        if (TicketUtils.checkPartnerTicketExpired(partnerTicketId))
            throw new NotAcceptableException("Partner ticket expires");


        OrderRecord orderRecord = new OrderRecord(customer.getId(), -1, customerTicketId, partnerTicketId,
                OrderStatus.WAITING.ordinal());
        orderRecordService.add(orderRecord);

        return new ResponseEntity<>(new Order(orderRecord.getId(), orderRecord.getCustomerId(),
                orderRecord.getPartnerId(), orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);

    }

    @GetMapping(value = "/participate/{orderId}")
    public ResponseEntity<?> participate(@PathVariable long orderId, HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

        if (orderRecord == null)
            throw new NotFoundException("Order not found");

        long partnerTicketId = orderRecord.getPartnerTicketId();
        if (TicketUtils.checkPartnerTicketExpired(partnerTicketId))
            throw new NotAcceptableException("Partner ticket expires");

        orderRecord.setPartnerId(userId);
        orderRecordService.updateOrderRecordWithPartnerId(orderId, userId);
        orderRecord.setStatus(OrderStatus.RECEIVED.ordinal());
        return new ResponseEntity<>(new Order(orderId, orderRecord.getCustomerId(), orderRecord.getPartnerId(),
                orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);
    }

    @GetMapping(value = "/cancel/{orderId}")
    public HttpStatus cancel(@PathVariable long orderId, HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

        if (orderRecord == null)
            throw new NotFoundException("Order not found");

        long ticketId = orderRecord.getPartnerTicketId();
        if (TicketUtils.checkTicketExpired(ticketId))
            throw new NotAcceptableException("Ticket expires");

        if (orderRecordService.isCustomer(orderId, userId)) {
            orderRecord.setStatus(OrderStatus.CANCELLED.ordinal());
            orderRecordService.updateOrderRecordWithStatus(orderId, OrderStatus.CANCELLED.ordinal());
        }
        else if (orderRecordService.isPartner(orderId, userId)) {
            orderRecord.setPartnerId(-1);
            orderRecord.setStatus(OrderStatus.WAITING.ordinal());
            orderRecordService.updateOrderRecordWithPartnerId(orderId, -1);
            orderRecordService.updateOrderRecordWithStatus(orderId, OrderStatus.WAITING.ordinal());
        }
        else {
            throw new NotFoundException("User not found");
        }

        return HttpStatus.NO_CONTENT;
    }

    @GetMapping(value = "/allorder")
    public ResponseEntity<?> allorder(HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        List<OrderRecord> orderRecords = orderRecordService.findOrderRecordsByCustomer(userId);

        return new ResponseEntity<>(orderRecords, HttpStatus.OK);
    }

}
