package com.debi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FlightBooking {
	@Id
	@GeneratedValue
	private Long id;
	private Long passengerId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Flight flight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "FlightBooking [id=" + id + ", passenger=" + passengerId + "]";
	}

}
