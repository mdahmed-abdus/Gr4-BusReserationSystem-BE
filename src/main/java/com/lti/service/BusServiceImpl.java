package com.lti.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.BusRepo;
import com.lti.entity.Bus;
import com.lti.exceptions.NoBusFoundException;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo bRepo;
	@Transactional
	@Override
	public Bus createBus(Bus b) {
		return bRepo.save(b);
	}

	@Override
	public List<Bus> listOfBuses() {
		return bRepo.findAll();
	}

	@Override
	public Bus findBusById(int busId) throws NoBusFoundException {
		Optional<Bus> bFind=bRepo.findById(busId);
		Bus b1=null;
		if(bFind.isPresent()) {
			b1=bFind.get();
		}
		else {
			throw new NoBusFoundException("Bus Not Found");
		}
		return b1;
	}
	
	
	@Transactional
	@Override
	public Bus updateBusById(int busId, Bus b) throws NoBusFoundException {
		Optional<Bus> bFind=bRepo.findById(busId);
		if(bFind.isPresent()) {
			bRepo.save(b);
		}
		else {
			throw new NoBusFoundException("Bus Not Found");
		}
		return b;
		
	}

	@Override
	public Bus deleteBusById(int busId) throws NoBusFoundException {
		Optional<Bus> bFind=bRepo.findById(busId);
		Bus b1=null;
		if(bFind.isPresent()) {
			b1=bFind.get();
			bRepo.delete(b1);
			
		}
		else {
			throw new NoBusFoundException("Bus Not Found");
		}
		return b1;
	}

}
