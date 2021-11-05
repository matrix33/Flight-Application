package com.debi.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private Long id;
	private String departureAirport;
	private String arrivalAirport;
	private String departureDayinWeek;

	public Flight() {
		super();
	}

	public Flight(Long id, String departureAirport, String arrivalAirport, String departureDayinWeek) {
		super();
		this.id = id;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureDayinWeek = departureDayinWeek;
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

	public String getDepartureDayinWeek() {
		return departureDayinWeek;
	}

	public void setDepartureDayinWeek(String departureDayinWeek) {
		this.departureDayinWeek = departureDayinWeek;
	}

}
