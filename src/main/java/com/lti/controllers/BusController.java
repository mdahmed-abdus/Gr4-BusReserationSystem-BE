package com.lti.controllers;

import java.time.LocalDate;
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
import com.lti.entity.Bus;
import com.lti.exceptions.NoBusFoundException;
import com.lti.service.BusService;

@CrossOrigin("http://localhost:4200")
@RestController
public class BusController {

	@Autowired
	private BusService bService;
	
	@GetMapping("/busses/newId")
	public int getNewId() {
		return this.getAllBuses().size() + 1;
	}
	

	@GetMapping("/buses")
	public List<Bus> getAllBuses(){
		return bService.listOfBuses();
	}
	
	@GetMapping("/buses/{busId}")
	public Bus getById(@PathVariable("busId")int busId) throws NoBusFoundException{
		return bService.findBusById(busId);
	}
	
	@PostMapping("/buses")
	public Bus addBus(@RequestBody Bus b) {
		b.setBusId(getNewId());
		return bService.createBus(b);
	}
	
	@PutMapping("/buses/{busId}")
	public Bus modifyBus(@PathVariable("busId")int busId,@RequestBody Bus b) throws NoBusFoundException{
		return bService.updateBusById(busId, b);
	}
	
	@DeleteMapping("/buses/{busId}")
	public Bus removeBus(@PathVariable("busId")int busId) throws NoBusFoundException {
		return bService.deleteBusById(busId);
	}
	

	
}
