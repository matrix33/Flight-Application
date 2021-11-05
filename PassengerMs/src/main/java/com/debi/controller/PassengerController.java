package com.debi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debi.model.Passenger;
import com.debi.service.PassengerService;

@RestController
@RequestMapping("/api/v1/passengerInfo")
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	
	@GetMapping("/id/{id}")
    public ResponseEntity<Passenger> getPassengerInfoById(@PathVariable Long id) {
		Passenger passenger = passengerService.findPassengerById(id);
		if(null == passenger) {
			return new ResponseEntity <Passenger>(passenger, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity <Passenger>(passenger, HttpStatus.ACCEPTED);
    }
	
	@GetMapping("/mail/{mailId}")
    public ResponseEntity<Passenger> getPassengerInfoByMail(@PathVariable String mailId) {
		Passenger passenger = passengerService.findPassengerByMailId(mailId);
		if(null == passenger) {
			return new ResponseEntity <Passenger>(passenger, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity <Passenger>(passenger, HttpStatus.ACCEPTED);
    }
	
	@PostMapping("/add")
    public ResponseEntity<Passenger> add(@RequestBody Passenger passengerInfo) {
		return new ResponseEntity <Passenger>(passengerService.addPassenger(passengerInfo), HttpStatus.CREATED);
    }
}
