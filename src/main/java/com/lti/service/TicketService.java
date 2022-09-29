package com.lti.service;

import java.util.List;
import com.lti.entity.Ticket;
import com.lti.exceptions.NoTicketFoundException;

public interface TicketService {

	public Ticket createTicket(Ticket t);
	public List<Ticket> listOfTickets();
	public Ticket findTicketById(int ticketId) throws NoTicketFoundException;
	public Ticket updateTicketById(int busId, Ticket t) throws NoTicketFoundException;
	public Ticket cancelTicketById(int busId) throws NoTicketFoundException;
}
