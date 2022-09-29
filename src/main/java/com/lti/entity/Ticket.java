package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ticket_Info")
public class Ticket {

	@Id
	private int ticketId;
	private String mail;
	private double total_amt;
	private int passengerCount;
	
	 
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="User_id")
	User user;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Bus_id")
	Bus bus;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Passenger> passengerList;
	
	
	
	public List<Passenger> getPassengerList() {
		return passengerList;
	}


	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}


	public Bus getBus() {
		return bus;
	}


	public void setBus(Bus bus) {
		this.bus = bus;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getTicketId() {
		return ticketId;
	}


	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public double getTotal_amt() {
		return total_amt;
	}


	public void setTotal_amt(double total_amt) {
		this.total_amt = total_amt;
	}


	public int getPassengerCount() {
		return passengerCount;
	}


	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", mail=" + mail + ", total_amt=" + total_amt + ", passengerCount="
				+ passengerCount + ", user=" + user + ", bus=" + bus + ", passengerList=" + passengerList + "]";
	}


	

	


	

	
	
	
	
	
	
}
