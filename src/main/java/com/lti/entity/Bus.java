package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bus_Info1")
public class Bus {

	@Id
	private int busId;
	private String busName;
	private String busType;
	private String duration;
	private LocalTime arrivalTime;
	private LocalTime depatureTime;
	private String source;
	private String destination;
	private double fare;
	private int totalNumberOfSeats;
	private LocalDate dateOfTravel;
	
//	@OneToMany(mappedBy="bus", cascade=CascadeType.ALL)
//	List<Ticket> tickets;
	
	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
//	public List<Ticket> getTickets() {
//		return tickets;
//	}
//	public void setTickets(List<Ticket> tickets) {
//		this.tickets = tickets;
//	}
	
	
	public int getBusId() {
		return busId;
	}
	
	public int getTotalNumberOfSeats() {
		return totalNumberOfSeats;
	}
	
	public void setTotalNumberOfSeats(int totalNumberOfSeats) {
		this.totalNumberOfSeats = totalNumberOfSeats;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalTime getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(LocalTime depatureTime) {
		this.depatureTime = depatureTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", busType=" + busType + ", duration=" + duration
				+ ", arrivalTime=" + arrivalTime + ", depatureTime=" + depatureTime + ", source=" + source
				+ ", destination=" + destination + ", fare=" + fare + ", totalNumberOfSeats=" + totalNumberOfSeats
				+ ", dateOfTravel=" + dateOfTravel + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
