package com.lti.service;

import java.util.List;
import com.lti.entity.Passenger;
import com.lti.exceptions.NoPassengerFoundException;

public interface PassengerService {

	public Passenger createPassenger(Passenger p);
	public List<Passenger> listOfPassengers();
	public Passenger findPassengerById(int passengerId) throws NoPassengerFoundException;
	public Passenger updatePassengerById(int passengerId, Passenger p) throws NoPassengerFoundException;
	public Passenger deletePassengerById(int passengerId) throws NoPassengerFoundException;
	
}
