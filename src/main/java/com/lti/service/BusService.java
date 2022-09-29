package com.lti.service;

import java.time.LocalDate;
import java.util.List;
import com.lti.entity.Bus;
import com.lti.exceptions.NoBusFoundException;

public interface BusService {

	public Bus createBus(Bus b);
	public List<Bus> listOfBuses();
	public Bus findBusById(int busId) throws NoBusFoundException;
//	public List<Bus> findBusesBySourceAndDestination(String source, String destination, LocalDate date) throws NoBusFoundException;
	public Bus updateBusById(int busId, Bus b) throws NoBusFoundException;
	public Bus deleteBusById(int busId) throws NoBusFoundException;
	
}
