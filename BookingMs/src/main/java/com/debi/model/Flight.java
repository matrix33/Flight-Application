package com.debi.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private Long id;
	private Long flightInfoId;
	private String departureAirport;
	private String arrivalAirport;
	private LocalDate departureDate;

	public Flight() {
		super();
	}

	public Flight(Long id, Long flightInfoId, String departureAirport, String arrivalAirport, LocalDate departureDate) {
		super();
		this.id = id;
		this.flightInfoId = flightInfoId;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureDate = departureDate;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public Long getFlightInfoId() {
		return flightInfoId;
	}

	public void setFlightInfoId(Long flightInfoId) {
		this.flightInfoId = flightInfoId;
	}
	
}
