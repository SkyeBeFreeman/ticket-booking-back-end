package com.teamid.controller;

import com.teamid.entity.*;
import com.teamid.entity.exception.NotAcceptableException;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.service.*;
import com.teamid.utils.LoginUtils;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    MovieService movieService;

    @Autowired
    CinemaService cinemaService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(long customerTicketId, long partnerTicketId, String message, HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        Ticket customerTicket = ticketService.getTicketById(customerTicketId);
        Ticket partnerTicket = ticketService.getTicketById(partnerTicketId);

        if (customerTicket == null)
            throw new NotFoundException("无效的订单");


        User customer = userService.findUserById(userId);
        if (customer == null)
            throw new NotFoundException("未注册的用户");

        if (ticketService.checkTicketExpired(customerTicketId))
            throw new NotAcceptableException("无效的电影票");
        if (partnerTicket != null && ticketService.checkPartnerTicketExpired(partnerTicketId))
            throw new NotAcceptableException("无效的电影票");

        OrderRecord orderRecord = new OrderRecord(customer.getId(), -1, customerTicketId, partnerTicketId,
                OrderStatus.WAITING.ordinal());
        orderRecordService.add(orderRecord);

        ticketService.modifyTicketStatusById(customerTicketId, TicketStatus.SOLD.ordinal());
        if (partnerTicket != null)
            ticketService.modifyTicketStatusById(partnerTicketId, TicketStatus.BOOKED.ordinal());
        ticketService.modifyTicketMessageById(partnerTicketId, message);

        return new ResponseEntity<>(new Order(orderRecord.getId(), orderRecord.getCustomerId(),
                orderRecord.getPartnerId(), orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);

    }

    @GetMapping(value = "/participate/{partnerTicketId}")
    public ResponseEntity<?> participate(@PathVariable long partnerTicketId, HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        if (partnerTicketId == -1)
            throw new NotAcceptableException("该订单不接受约影");

        Ticket partnerTicket = ticketService.getTicketById(partnerTicketId);

        if (partnerTicket == null)
            throw new NotAcceptableException("无效的电影票");

        if (ticketService.checkPartnerTicketExpired(partnerTicketId))
            throw new NotAcceptableException("电影开场前一小时以后不接受约影");

        OrderRecord orderRecord = orderRecordService.findOrderRecordByPartnerTicketId(partnerTicket.getId());

        if (userId == orderRecord.getCustomerId())
            throw new NotAcceptableException("不能和自己约影噢= =");

        long orderId = orderRecord.getId();

        orderRecord.setPartnerId(userId);
        orderRecordService.updateOrderRecordWithPartnerId(orderId, userId);
        orderRecord.setStatus(OrderStatus.RECEIVED.ordinal());
        orderRecordService.updateOrderRecordWithStatus(orderId, OrderStatus.RECEIVED.ordinal());
        ticketService.modifyTicketStatusById(partnerTicketId, TicketStatus.SOLD.ordinal());

        return new ResponseEntity<>(new Order(orderId, orderRecord.getCustomerId(), orderRecord.getPartnerId(),
                orderRecord.getCustomerTicketId(), orderRecord.getPartnerTicketId()), HttpStatus.OK);
    }

    @GetMapping(value = "/cancel/{orderId}")
    public HttpStatus cancel(@PathVariable long orderId, HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

        if (orderRecord == null)
            throw new NotFoundException("无效的订单");

        long customerTicketId = orderRecord.getCustomerTicketId();
        long partnerTicketId = orderRecord.getPartnerTicketId();

        if (orderRecord.getStatus() == OrderStatus.CANCELLED.ordinal())
            throw new NotAcceptableException("不能重复取消订单");

        if (orderRecord.getStatus() == OrderStatus.FINISHED.ordinal())
            throw new NotAcceptableException("不能取消已完成的订单");

        if (orderRecordService.isCustomer(orderId, userId)) {
            if (ticketService.checkTicket1hExpired(customerTicketId))
                throw new NotAcceptableException("开场前一小时不能取消订单");
            orderRecord.setStatus(OrderStatus.CANCELLED.ordinal());
            orderRecordService.updateOrderRecordWithStatus(orderId, OrderStatus.CANCELLED.ordinal());
            ticketService.modifyTicketStatusById(customerTicketId, TicketStatus.NOT_SOLD_OUT.ordinal());
            ticketService.modifyTicketStatusById(partnerTicketId, TicketStatus.NOT_SOLD_OUT.ordinal());
        }
        else if (orderRecordService.isPartner(orderId, userId)) {
            if (ticketService.checkTicket1hExpired(partnerTicketId))
                throw new NotAcceptableException("开场前一小时不能取消订单");
            orderRecord.setPartnerId(-1);
            orderRecord.setStatus(OrderStatus.WAITING.ordinal());
            orderRecordService.updateOrderRecordWithPartnerId(orderId, -1);
            orderRecordService.updateOrderRecordWithStatus(orderId, OrderStatus.WAITING.ordinal());
            ticketService.modifyTicketStatusById(partnerTicketId, TicketStatus.BOOKED.ordinal());
        }
        else {
            throw new NotFoundException("不是该订单的用户");
        }

        return HttpStatus.NO_CONTENT;
    }

    @GetMapping(value = "/allorder")
    public ResponseEntity<?> allorder(HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);
        List<OrderDetail> orderDetails = new ArrayList<>();

        List<OrderRecord> customerOrderRecords = orderRecordService.findOrderRecordsByCustomerId(userId);
        List<OrderRecord> partnerOrderRecords = orderRecordService.findOrderRecordsByPartnerId(userId);

        List<OrderRecord> orderRecords = customerOrderRecords;
        orderRecords.addAll(partnerOrderRecords);

        for (int i = 0; i < orderRecords.size(); i++) {
            long orderId = orderRecords.get(i).getId();
            long customerId = orderRecords.get(i).getCustomerId();
            long partnerId = orderRecords.get(i).getPartnerId();
            long customerTicketId = orderRecords.get(i).getCustomerTicketId();
            long partnerTicketId = orderRecords.get(i).getPartnerTicketId();


            User customer = userService.findUserById(userId);
            User partner = userService.findUserById(partnerId);
            Ticket ticket = ticketService.getTicketById(customerTicketId);

            if (ticketService.checkTicketExpired(customerTicketId)) {
                orderRecordService.updateOrderRecordWithStatus(orderId, OrderStatus.FINISHED.ordinal());
                orderRecords.get(i).setStatus(OrderStatus.FINISHED.ordinal());
            }

            int orderStatus = orderRecords.get(i).getStatus();
            long scheduleId = ticket.getScheduleId();
            Schedule schedule = scheduleService.findScheduleByScheduleId(scheduleId).get();
            long movieId = schedule.getMovieId();
            Movie movie = movieService.findMovieById(movieId);
            long cinemaId = schedule.getCinemaId();
            Cinema cinema = cinemaService.findCinemaById(cinemaId);

            String movieNameCn = movie.getNameCn();
            String movieNameEn = movie.getNameEn();

            LocalDateTime startTime = schedule.getStartTime();
            String endTime = schedule.getEndTime();

            String cinemaName = cinema.getName();
            int posX = ticket.getPosX();
            int posY = ticket.getPosY();

            String customerPhone = customer.getPhone();
            String partnerPhone = "-1";
            if (partner != null)
                partnerPhone = partner.getPhone();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM月dd日 HH:mm");

            OrderDetail orderDetail;
            if (i < customerOrderRecords.size()) {
                orderDetail = new OrderDetail(orderId, customerId, partnerId, customerTicketId,
                        partnerTicketId, orderStatus, movieNameCn, movieNameEn, startTime.format(formatter), endTime,
                        cinemaName, posX, posY, customerPhone, partnerPhone);
            }
            else {
                orderDetail = new OrderDetail(orderId, customerId, partnerId, customerTicketId,
                        partnerTicketId, orderStatus, movieNameCn, movieNameEn, startTime.format(formatter), endTime,
                        cinemaName, posX, posY, partnerPhone, customerPhone);
            }

            orderDetails.add(orderDetail);

        }

        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

}
