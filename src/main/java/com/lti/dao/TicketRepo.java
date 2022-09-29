package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.Ticket;

@Repository
public interface TicketRepo  extends JpaRepository<Ticket, Integer> {

}
