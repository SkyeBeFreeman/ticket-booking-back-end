package com.teamid.controller;

import com.teamid.entity.*;
import com.teamid.entity.exception.NotAcceptableException;
import com.teamid.entity.exception.NotFoundException;
import com.teamid.service.*;
import com.teamid.utils.LoginUtils;
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

    @GetMapping(value = "/participate/{orderId}")
    public ResponseEntity<?> participate(@PathVariable long orderId, HttpSession session) {

        long userId = LoginUtils.getLoginUserId(session);

        OrderRecord orderRecord = orderRecordService.findOrderRecordById(orderId);

        if (orderRecord == null)
            throw new NotFoundException("无效的订单");

        long partnerTicketId = orderRecord.getPartnerTicketId();
        if (partnerTicketId == -1)
            throw new NotAcceptableException("该订单不接受约影");
        if (ticketService.checkPartnerTicketExpired(partnerTicketId))
            throw new NotAcceptableException("无效的电影票");

        orderRecord.setPartnerId(userId);
        orderRecordService.updateOrderRecordWithPartnerId(orderId, userId);
        orderRecord.setStatus(OrderStatus.RECEIVED.ordinal());
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

        List<OrderRecord> orderRecords = orderRecordService.findOrderRecordsByCustomer(userId);

        for (OrderRecord orderRecord : orderRecords) {
            long orderId = orderRecord.getId();
            long customerId = orderRecord.getCustomerId();
            long partnerId = orderRecord.getPartnerId();
            long customerTicketId = orderRecord.getCustomerTicketId();
            long partnerTicketId = orderRecord.getPartnerTicketId();


            User partner = userService.findUserById(userId);
            Ticket ticket = ticketService.getTicketById(customerTicketId);

            if (ticketService.checkTicketExpired(customerTicketId)) {
                orderRecordService.updateOrderRecordWithStatus(orderId, OrderStatus.FINISHED.ordinal());
                orderRecord.setStatus(OrderStatus.FINISHED.ordinal());
            }

            int orderStatus = orderRecord.getStatus();
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

            String partnerPhone = partner.getPhone();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM月dd日 HH:mm");

            OrderDetail orderDetail = new OrderDetail(orderId, customerId, partnerId, customerTicketId,
                    partnerTicketId, orderStatus, movieNameCn, movieNameEn, startTime.format(formatter), endTime,
                    cinemaName, posX, posY, partnerPhone);

            orderDetails.add(orderDetail);

        }

        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

}
