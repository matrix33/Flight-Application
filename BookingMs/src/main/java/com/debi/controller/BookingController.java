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

import com.debi.model.FlightBooking;
import com.debi.service.BookingService;
import com.debi.util.BookingCriteria;

@RestController
@RequestMapping("/api/v1/bookingInfo")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@GetMapping("/id/{id}")
    public ResponseEntity<FlightBooking> getBookingInfoById(@PathVariable Long id) {
		FlightBooking booking = bookingService.findBookingById(id);
		if(null == booking) {
			return new ResponseEntity <FlightBooking>(booking, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity <FlightBooking>(booking, HttpStatus.ACCEPTED);
    }
	
	@PostMapping("/add")
    public ResponseEntity<FlightBooking> add(@RequestBody BookingCriteria bookingCriteria) {
		return new ResponseEntity <FlightBooking>(bookingService.addBooking(bookingCriteria), HttpStatus.CREATED);
    }
	
	@GetMapping("/passengerId/{id}")
    public ResponseEntity<List<FlightBooking>> getBookingsForPassenger(@PathVariable Long passengerId) {
		List<FlightBooking> booking = bookingService.findBookingByPassengerId(passengerId);
		if(null == booking || booking.isEmpty()) {
			return new ResponseEntity <List<FlightBooking>>(booking, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity <List<FlightBooking>>(booking, HttpStatus.ACCEPTED);
    }
}
