package com.lti.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Bus;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.service.EmailService;

@CrossOrigin("http://localhost:4200")
@RestController
public class EmailController {
	
	
	@Autowired
	private EmailService emailService;
	
//	@RequestMapping("/welcome")
//	public String welcome()
//	{
//		return "hello this is my email";
//	}
	
	@PostMapping("/sendmail")
	public ResponseEntity<?> sendEmail(@RequestBody Ticket ticket){ 
		
		
	//Bus u1= bus;
	Ticket t1 = ticket;
	String Subject = "Ticket detalis are";
	String message = "Details are "+t1.toString()+"";
	String to =t1.getMail(); 
	
	
	boolean result = this.emailService.sendEmial( Subject , message, to);
	if(result)
	{
		return ResponseEntity.ok("email is sent");
	}else
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent....");
	}
		
	} 

}
