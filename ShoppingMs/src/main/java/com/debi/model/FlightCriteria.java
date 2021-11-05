package com.debi.model;

import java.time.LocalDate;

public class FlightCriteria {

	private String departureAirport;
	private String arrivalAirport;
	private LocalDate departureDate;
	
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
	public FlightCriteria(String departureAirport, String arrivalAirport, LocalDate departureDate) {
		super();
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureDate = departureDate;
	}
	public FlightCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}