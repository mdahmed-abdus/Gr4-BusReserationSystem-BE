package com.lti;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.BusRepo;
import com.lti.dao.PassengerRepo;
import com.lti.dao.TicketRepo;
import com.lti.dao.UserRepo;
import com.lti.entity.Bus;
import com.lti.entity.Passenger;
import com.lti.entity.Ticket;
import com.lti.entity.User;
import com.lti.exceptions.NoBusFoundException;
import com.lti.exceptions.NoPassengerFoundException;
import com.lti.exceptions.NoTicketFoundException;
import com.lti.exceptions.NoUserFoundException;
import com.lti.service.BusService;
import com.lti.service.PassengerService;
import com.lti.service.TicketService;
import com.lti.service.UserService;

@SpringBootTest
class BusReservationSystemBackend1ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	UserRepo uRepo;
	
	@Autowired
	UserService uService;
	
	@Test
	public void testcreateUser() {
		User u=new User();
		u.setUser_Id(108);
		u.setFname("Ria");
		u.setLname("Rai");
		u.setGender("Female");
		u.setPhoneNo(997954321);
		u.setAddress("Mumbai");
		u.setMail("ria@gmail.com");
		u.setPwd("Ria@123");
		u.setWallet(12000.0);
		u.setUserType("Non-Admin");
		u.setDob(LocalDate.parse("2004-05-02",DateTimeFormatter.ISO_DATE));
//		uRepo.save(u);
		uService.createUser(u);
		Assertions.assertTrue(uService.createUser(u)instanceof User );
//		assertNotNull(u.getUser_Id());//pass 
		
	}
	
	@Test
	public void testReadAllUsers() {
//		List<User> ulist=uRepo.findAll();
		List<User> ulist=uService.listOfUsers();
		assertThat(ulist).size().isGreaterThan(0);
	}

	@Test
	public void testSingleUser() throws NoUserFoundException {
//		User user=uRepo.findById(108).get();
		User user=uService.findUserById(108);
		assertEquals("Ria",user.getFname());//pass
		
	}
	
	@Test
	public void testSingleUserByMail() throws NoUserFoundException {
		User user=uService.findUserByMail("ria@gmail.com");
		assertEquals("Ria",user.getFname());
	}
	
	@Test
	public void testUpdateUser() throws NoUserFoundException {
		User u=new User();
		u.setUser_Id(108);
		u.setFname("Ria");
		u.setLname("Rai");
		u.setGender("Female");
		u.setPhoneNo(997954321);
		u.setAddress("Mumbai");
		u.setMail("ria@gmail.com");
		u.setPwd("Ria@123");
		u.setWallet(13000.0);
		u.setUserType("Non-Admin");
		u.setDob(LocalDate.parse("2004-05-02",DateTimeFormatter.ISO_DATE));

//		User u=uService.findUserById(108);
//		u.setWallet(12500.0);

		uService.updateUserById(u.getUser_Id(),u);
		assertNotEquals(12000.0, uService.findUserById(108).getWallet());
	}
	
	@Test
	public void testDeleteUser() throws NoUserFoundException {
//		uRepo.deleteById(108);
		uService.deleteUserById(108);
		assertThat(uRepo.existsById(108)).isFalse();
		
	}
	
	
	@Autowired
	PassengerRepo pRepo;
	@Autowired
	PassengerService pService;

	
	@Test
	public void testcreatePassenger() {
		Passenger p=new Passenger();
		p.setPassengerId(418);
		p.setPassengerName("Mohit");
		p.setPassengerAge(24);
		p.setSeatNumber("B27");
		pService.createPassenger(p);
		Assertions.assertTrue(pService.createPassenger(p)instanceof Passenger );
	}
	
	@Test
	public void testReadAllPassengers() {
		List<Passenger> plist=pService.listOfPassengers();
		assertThat(plist).size().isGreaterThan(0);
	}
	
	@Test
	public void testSinglePassenger() throws NoPassengerFoundException {
		Passenger passenger=pService.findPassengerById(418);
		assertEquals("Mohit",passenger.getPassengerName());
		
	}
	
	@Test
	public void testUpdatePassenger() throws NoPassengerFoundException {
		Passenger p=new Passenger();
		p.setPassengerId(418);
		p.setPassengerName("Mohit");
		p.setPassengerAge(26);
		p.setSeatNumber("B27");
		pService.updatePassengerById(p.getPassengerId(),p);
		assertNotEquals(24, pService.findPassengerById(418).getPassengerAge());
	}
	
	@Test
	public void testDeletePassenger() throws NoPassengerFoundException {
		pService.deletePassengerById(418);
		assertThat(pRepo.existsById(418)).isFalse();
	}
	
	
	@Autowired
	private BusRepo bRepo;
	
	@Autowired
	private BusService bService;
	
	@Test
	public void testcreateBus() {

		Bus b = new Bus();
		b.setBusId(208);
		b.setBusName("Mum_Exp");
		b.setBusType("AC");
		b.setDuration("12 hours");
		b.setDuration("12 Hours");
		b.setArrivalTime(LocalTime.parse("05:00:00",DateTimeFormatter.ISO_TIME));
		b.setDepatureTime(LocalTime.parse("07:00:00",DateTimeFormatter.ISO_TIME));
		b.setSource("Pune");
		b.setDestination("Lucknow");
		b.setFare(700);
		b.setTotalNumberOfSeats(59);
		b.setDateOfTravel(LocalDate.parse("2022-05-02",DateTimeFormatter.ISO_DATE));
		bService.createBus(b);
		
		Assertions.assertTrue(bService.createBus(b)instanceof Bus);
		
		
	}
	
	@Test
	public void testReadAllBus() {
		List<Bus> blist=bService.listOfBuses();
		assertThat(blist).size().isGreaterThan(0);
	}

	
	@Test
	public void testSingleBus() throws NoBusFoundException{
		
		Bus bus=bService.findBusById(208);
		assertEquals("Mum_Exp",bus.getBusName());//pass
		
	}
	
	@Test
	public void testUpdateBus() throws NoBusFoundException{
		Bus b = new Bus();
		b.setBusId(208);
		b.setBusName("Mum_Exp");
		b.setBusType("Non-AC");
		b.setDuration("12 hours");
		b.setDuration("12 Hours");
		b.setArrivalTime(LocalTime.parse("05:00:00",DateTimeFormatter.ISO_TIME));
		b.setDepatureTime(LocalTime.parse("07:00:00",DateTimeFormatter.ISO_TIME));
		b.setSource("Pune");
		b.setDestination("Lucknow");
		b.setFare(700);
		b.setTotalNumberOfSeats(59);
		b.setDateOfTravel(LocalDate.parse("2022-05-02",DateTimeFormatter.ISO_DATE));
		bService.updateBusById(b.getBusId(),b);
		assertNotEquals("AC", bService.findBusById(208).getBusType());
	}
	
	@Test
	public void testDeleteBus() throws NoBusFoundException{
		
		bService.deleteBusById(208);
		assertThat(bRepo.existsById(208)).isFalse();
	
	}
	
	
	
	@Autowired 
	private TicketRepo tRepo;
	
	@Autowired TicketService tService;
	
	@Test
	public void testcreateTicket() {
		
		Ticket t = new Ticket();
		t.setTicketId(703);
		t.setMail("virat@gmail.com");
		t.setTotal_amt(180);
		t.setPassengerCount(2);
		tService.createTicket(t);
		Assertions.assertTrue(tService.createTicket(t)instanceof Ticket );
	}
	
	@Test
	public void testReadAllTicket() {
		List<Ticket> tlist=tService.listOfTickets();
		assertThat(tlist).size().isGreaterThan(0);
	}

	@Test
	public void testSingleTicket() throws NoTicketFoundException {
		Ticket ticket = tService.findTicketById(703);
		assertEquals("virat@gmail.com",ticket.getMail());
	
	}
	
	
	@Test
	public void testUpdateTicket() throws NoTicketFoundException{
		Ticket t = new Ticket();
		t.setTicketId(703);
		t.setMail("virat@gmail.com");
		t.setTotal_amt(180);
		t.setPassengerCount(3);
		tService.updateTicketById(t.getTicketId(),t);
		assertNotEquals("2", tService.findTicketById(703).getPassengerCount());
	}
	
     @Test
	   public void testDeleteTicket() throws  NoTicketFoundException{
		tService.cancelTicketById(703);
		assertThat(pRepo.existsById(703)).isFalse();
     }
	


	
	


}
