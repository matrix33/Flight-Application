package com.debi.util;

import java.time.LocalDate;

public class BookingCriteria{
	
	private String passengerMailId;
	private Long flightId;
	private LocalDate flightDepartureDate;
	
	public String getPassengerMailId() {
		return passengerMailId;
	}
	public void setPassengerMailId(String passengerMailId) {
		this.passengerMailId = passengerMailId;
	}
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public LocalDate getFlightDepartureDate() {
		return flightDepartureDate;
	}
	public void setFlightDepartureDate(LocalDate flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}
	public BookingCriteria(String passengerMailId, Long flightId, LocalDate flightDepartureDate) {
		super();
		this.passengerMailId = passengerMailId;
		this.flightId = flightId;
		this.flightDepartureDate = flightDepartureDate;
	}
	public BookingCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookingCriteria [passengerMailId=" + passengerMailId + ", flightId=" + flightId
				+ ", flightDepartureDate=" + flightDepartureDate + "]";
	}
	
}
