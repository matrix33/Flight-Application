package com.debi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debi.exception.BsnsObjException;
import com.debi.model.Flight;
import com.debi.model.FlightCriteria;
import com.debi.repository.FlightInfoRepository;

@Service
public class FlightInfoServiceImpl implements FlightInfoService {

	@Autowired
	FlightInfoRepository repo;
	
	@Override
	public Flight findFlightById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new BsnsObjException("No Such flight exist."));
	}

	@Override
	public Flight addFlight(Flight flightInfo) {
		return repo.save(flightInfo);
	}

	@Override
	public List<Flight> getFlightByDateAirport(FlightCriteria criteria) {
		List<Flight> flightList = null;
		if(criteria.getDepartureDate() != null && criteria.getDepartureAirport() != null && criteria.getArrivalAirport() != null) {
			int dayOfWeek = criteria.getDepartureDate().getDayOfWeek().getValue();
			flightList = repo.getFlightByDateAirport(dayOfWeek, criteria.getDepartureAirport(), criteria.getArrivalAirport());
		}
		return flightList;
	}

}
