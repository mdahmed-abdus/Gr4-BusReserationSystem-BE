package com.lti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Passenger;
import com.lti.exceptions.NoPassengerFoundException;
import com.lti.service.PassengerService;




@CrossOrigin("http://localhost:4200")
@RestController
public class PassengerController {

	@Autowired
	private PassengerService pService;
	
	@GetMapping("/passengers/newId")
	public int getNewId() {
		return getAllPassengers().size() + 1;
	}
	

	@GetMapping("/passengers")
	public List<Passenger> getAllPassengers(){
		return pService.listOfPassengers();
	}
	
	@GetMapping("/passengers/{passengerId}")
	public Passenger getById(@PathVariable("passengerId")int passengerId) throws NoPassengerFoundException{
		return pService.findPassengerById(passengerId);
	}
	
	@PostMapping("/passengers")
	public Passenger addPassenger(@RequestBody Passenger p) {
		p.setPassengerId(getNewId());
		return pService.createPassenger(p);
	}
	
	@PutMapping("/passengers/{passengerId}")
	public Passenger modifyPassenger(@PathVariable("passengerId")int passengerId,@RequestBody Passenger p) throws NoPassengerFoundException{
		return pService.updatePassengerById(passengerId, p);
	}
	
	@DeleteMapping("/passengers/{passengerId}")
	public Passenger removePassenger(@PathVariable("passengerId")int passengerId) throws NoPassengerFoundException {
		return pService.deletePassengerById(passengerId);
	}
}
