package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.dao.TicketRepo;
import com.lti.entity.Ticket;
import com.lti.exceptions.NoTicketFoundException;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepo tRepo;
	@Transactional
	@Override
	public Ticket createTicket(Ticket t) {
		return tRepo.save(t);
	}

	@Override
	public List<Ticket> listOfTickets() {
		return tRepo.findAll();
	}

	@Override
	public Ticket findTicketById(int ticketId) throws NoTicketFoundException {
		Optional<Ticket> tFind=tRepo.findById(ticketId);
		Ticket t1=null;
		if(tFind.isPresent()) {
			t1=tFind.get();
		}
		else {
			throw new NoTicketFoundException("Ticket Not Found");
		}
		return t1;
	}

	@Transactional
	@Override
	public Ticket updateTicketById(int ticketId, Ticket t) throws NoTicketFoundException {
		Optional<Ticket> tFind=tRepo.findById(ticketId);
		if(tFind.isPresent()) {
			tRepo.save(t);
		}
		else {
			throw new NoTicketFoundException("Ticket Not Found");
		}
		return t;
		
	}

	@Override
	public Ticket cancelTicketById(int ticketId) throws NoTicketFoundException {
		
		Optional<Ticket> tFind=tRepo.findById(ticketId);
		Ticket t1=null;
		if(tFind.isPresent()) {
			t1=tFind.get();
			tRepo.delete(t1);
			
		}
		else {
			throw new NoTicketFoundException("Ticket Not Found");
		}
		return t1;
	}

}
