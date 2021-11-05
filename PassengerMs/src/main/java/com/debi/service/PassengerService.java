package com.debi.service;

import com.debi.model.Passenger;

public interface PassengerService {

	Passenger findPassengerById(Long id);
	
	Passenger findPassengerByMailId(String mailId);

	Passenger addPassenger(Passenger flightInfo);

}
