package com.debi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debi.exception.BsnsObjException;
import com.debi.model.Flight;
import com.debi.model.FlightCriteria;
import com.debi.service.FlightInfoService;

@RestController
@RequestMapping("/api/v1/flightInfo")
public class ShoppingController {

	@Autowired
	FlightInfoService flightInfoService;
	
	@GetMapping("{id}")
    public ResponseEntity<Flight> getFlightInfoById(@PathVariable Long id) {
		Flight flight = flightInfoService.findFlightById(id);
		if(null == flight) {
			return new ResponseEntity <Flight>(flight, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity <Flight>(flight, HttpStatus.ACCEPTED);
    }
	
	@GetMapping("/find")
    public ResponseEntity<Long> getFlightInfoByDepartureDate(
    		@RequestBody FlightCriteria criteria){
		if(null == criteria) {
			throw new BsnsObjException("Departure date format is not valid.");
		}else {
			List<Flight> flightList = flightInfoService.getFlightByDateAirport(criteria);
			if(null==flightList || flightList.isEmpty()) {
				return new ResponseEntity <Long>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity <Long>(flightList.get(0).getId(), HttpStatus.ACCEPTED);
		}
    }
	
	@PostMapping("/add")
    public ResponseEntity<Flight> add(@RequestBody Flight flightInfo) {
		return new ResponseEntity <Flight>(flightInfoService.addFlight(flightInfo), HttpStatus.CREATED);
    }
}
