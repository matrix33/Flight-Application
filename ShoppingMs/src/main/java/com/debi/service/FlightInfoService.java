package com.debi.service;

import java.util.List;

import com.debi.model.Flight;
import com.debi.model.FlightCriteria;

public interface FlightInfoService {

	Flight findFlightById(Long id);

	Flight addFlight(Flight flightInfo);

	List<Flight> getFlightByDateAirport(FlightCriteria criteria);

}
