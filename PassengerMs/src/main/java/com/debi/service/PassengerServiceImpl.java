package com.debi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.debi.exception.BsnsObjException;
import com.debi.model.Passenger;
import com.debi.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerRepository repo;
	
	@Override
	public Passenger findPassengerById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new BsnsObjException("No Such flight exist."));
	}
	
	@Override
	public Passenger findPassengerByMailId(@PathVariable String mailId) {
		return repo.findByEmail(mailId);
	}

	@Override
	public Passenger addPassenger(Passenger flightInfo) {
		return repo.save(flightInfo);
	}

}
