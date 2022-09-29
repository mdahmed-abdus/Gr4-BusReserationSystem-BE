package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.dao.PassengerRepo;
import com.lti.entity.Bus;
import com.lti.entity.Passenger;
import com.lti.exceptions.NoBusFoundException;
import com.lti.exceptions.NoPassengerFoundException;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepo pRepo;
	@Transactional
	@Override
	public Passenger createPassenger(Passenger p) {
		return pRepo.save(p);
	}

	@Override
	public List<Passenger> listOfPassengers() {
		
		return pRepo.findAll();
	}

	@Override
	public Passenger findPassengerById(int passengerId) throws NoPassengerFoundException {
		Optional<Passenger> pFind=pRepo.findById(passengerId);
		Passenger p1=null;
		if(pFind.isPresent()) {
			p1=pFind.get();
		}
		else {
			throw new NoPassengerFoundException("Passenger Not Found");
		}
		return p1;
		
	}

	@Transactional
	@Override
	public Passenger updatePassengerById(int passengerId, Passenger p) throws NoPassengerFoundException {
		Optional<Passenger> pFind=pRepo.findById(passengerId);
		if(pFind.isPresent()) {
			pRepo.save(p);
		}
		else {
			throw new NoPassengerFoundException("Passenger Not Found");
		}
		return p;
		
	}

	@Override
	public Passenger deletePassengerById(int passengerId) throws NoPassengerFoundException {
		Optional<Passenger> pFind=pRepo.findById(passengerId);
		Passenger p1=null;
		if(pFind.isPresent()) {
			p1=pFind.get();
			pRepo.delete(p1);
			
		}
		else {
			throw new NoPassengerFoundException("Passenger Not Found");
		}
		return p1;
	}

}
