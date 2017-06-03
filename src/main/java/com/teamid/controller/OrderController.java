package com.teamid.controller;

import com.teamid.entity.Order;
import com.teamid.entity.OrderRecord;
import com.teamid.entity.OrderStatus;
import com.teamid.entity.User;
import com.teamid.service.OrderRecordService;
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
    UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody long customerTicketId,
                                    @RequestBody long partnerTicketId, String message, HttpSession session) {
        long userId = (long) session.getAttribute("userId");

        User cumtomer = userService.findUserById(userId);

        OrderRecord orderRecord = new OrderRecord(cumtomer.getId(), -1, customerTicketId, partnerTicketId, message,
                OrderStatus.WAITING.ordinal());
        orderRecordService.add(orderRecord);

        return new ResponseEntity<Object>(new Order(orderRecord.getId(), orderRecord.getCustomerId(),
                orderRecord.getPartnerId(), orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);

    }

    @RequestMapping(value = "/participate/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<?> participate(@PathVariable long orderId, HttpSession session) {
        long userId = (long) session.getAttribute("userId");
        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

        orderRecord.setPartnerId(userId);

        orderRecordService.updateOrderRecordWithPartnerId(orderId, userId);

        orderRecord.setStatus(OrderStatus.RECEIVED.ordinal());
        return new ResponseEntity<Object>(new Order(orderId, orderRecord.getCustomerId(), orderRecord.getPartnerId(),
                orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);
    }

    @RequestMapping(value = "/cancel/{orderId}", method = RequestMethod.GET)
    public HttpStatus cancel(@PathVariable long orderId, HttpSession session) {
        long userId = (long) session.getAttribute("userId");
        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

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
            return null;
        }

        return HttpStatus.NO_CONTENT;
    }

    @RequestMapping(value = "/allorder", method = RequestMethod.GET)
    public ResponseEntity<?> allorder(HttpSession session) {
        long userId = (long) session.getAttribute("userId");

        List<OrderRecord> orderRecords = orderRecordService.findOrderRecordsByCustomer(userId);

        return new ResponseEntity<Object>(orderRecords, HttpStatus.OK);
    }

}
