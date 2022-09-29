package com.lti.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.entity.Ticket;
import com.lti.exceptions.NoTicketFoundException;
import com.lti.service.TicketService;

@CrossOrigin("http://localhost:4200")
@RestController
public class TicketController {

	@Autowired
	private TicketService tService;
	
	@GetMapping("/tickets/newId")
	public int getNewId()
	{
		return getAllTickets().size() + 1;
	}

	@GetMapping("/tickets")
	public List<Ticket> getAllTickets() {
		return tService.listOfTickets();
	}
	
	@GetMapping("/tickets/user/{userId}")
	public List<Ticket> getAllTicketsByUserId(@PathVariable("userId") int userId) {
		return getAllTickets().stream().filter(t -> t.getUser().getUser_Id() == userId).collect(Collectors.toList());
	}
	
	@GetMapping("/tickets/{ticketId}")
	public Ticket getById(@PathVariable("ticketId")int ticketId) throws NoTicketFoundException{
		return tService.findTicketById(ticketId);
	}
	
	@PostMapping("/tickets")
	public Ticket addTicket(@RequestBody Ticket t) {
		t.setTicketId(getNewId());
		return tService.createTicket(t);
	}
	
	
	
	@DeleteMapping("/tickets/{ticketId}")
	public Ticket removeTicket(@PathVariable("ticketId")int ticketId) throws NoTicketFoundException {
		return tService.cancelTicketById(ticketId);
	}
}
