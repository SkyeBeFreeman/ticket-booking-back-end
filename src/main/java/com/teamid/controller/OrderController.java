package com.teamid.controller;

import com.teamid.entity.Order;
import com.teamid.entity.OrderRecord;
import com.teamid.entity.OrderStatus;
import com.teamid.entity.User;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.entity.exception.UnauthorizedException;
import com.teamid.service.OrderRecordService;
import com.teamid.service.TicketService;
import com.teamid.service.UserService;
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
    public ResponseEntity<?> create(@RequestBody long customerTicketId,
                                    @RequestBody long partnerTicketId, HttpSession session) {

        if (session.getAttribute("userId") == null)
            throw new UnauthorizedException("Login first");

        if (ticketService.getTicketById(customerTicketId) == null
                || ticketService.getTicketById(partnerTicketId) == null)
            throw new NotFoundException("Ticket id not found");

        long userId = (long) session.getAttribute("userId");

        User customer = userService.findUserById(userId);

        if (customer == null)
            throw new NotFoundException("User not found");


        OrderRecord orderRecord = new OrderRecord(customer.getId(), -1, customerTicketId, partnerTicketId,
                OrderStatus.WAITING.ordinal());
        orderRecordService.add(orderRecord);

        return new ResponseEntity<>(new Order(orderRecord.getId(), orderRecord.getCustomerId(),
                orderRecord.getPartnerId(), orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);

    }

    @GetMapping(value = "/participate/{orderId}")
    public ResponseEntity<?> participate(@PathVariable long orderId, HttpSession session) {

        if (session.getAttribute("userId") == null)
            throw new UnauthorizedException("Login first");

        long userId = (long) session.getAttribute("userId");
        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

        if (orderRecord != null)
            throw new NotFoundException("Order not found");

        orderRecord.setPartnerId(userId);
        orderRecordService.updateOrderRecordWithPartnerId(orderId, userId);
        orderRecord.setStatus(OrderStatus.RECEIVED.ordinal());
        return new ResponseEntity<>(new Order(orderId, orderRecord.getCustomerId(), orderRecord.getPartnerId(),
                orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);
    }

    @GetMapping(value = "/cancel/{orderId}")
    public HttpStatus cancel(@PathVariable long orderId, HttpSession session) {

        if (session.getAttribute("userId") == null)
            throw new UnauthorizedException("Login first");

        long userId = (long) session.getAttribute("userId");
        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

        if (orderRecord != null)
            throw new NotFoundException("Order not found");

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

        if (session.getAttribute("userId") == null)
            throw new UnauthorizedException("Login first");

        long userId = (long) session.getAttribute("userId");

        List<OrderRecord> orderRecords = orderRecordService.findOrderRecordsByCustomer(userId);

        return new ResponseEntity<>(orderRecords, HttpStatus.OK);
    }

}
