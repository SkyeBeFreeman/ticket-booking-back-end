package com.teamid.repository;

import com.teamid.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Skye on 2017/6/3.
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {



}
