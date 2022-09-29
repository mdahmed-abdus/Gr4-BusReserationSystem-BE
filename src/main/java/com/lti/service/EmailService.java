package com.lti.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.lti.entity.Bus;
import com.lti.entity.Ticket;

@Service
public class EmailService {
	
public boolean sendEmial(String subject , String message ,String to ) {
		
		boolean f=false;
		String from = "188r1a0525@cmrec.ac.in";
		String host= "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step 1 to get session object
		Session session = Session.getInstance(properties , new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("188r1a0525@cmrec.ac.in","****");
				
			}
			
		});
		
		session.setDebug(true);
		
		//step component the message [txt,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
			
			//from email
			m.setFrom(from);
			
			//adding recipent to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//Adding subject to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//send
			//step 3 send message using TRansport class
			Transport.send(m);
			
			System.out.println("sent success................");
			f = true;
		}
		catch(Exception e) {

			e.printStackTrace();
		}
		return f;
	}

}
