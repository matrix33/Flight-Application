package com.debi.service;

import java.util.List;

import com.debi.model.FlightBooking;
import com.debi.util.BookingCriteria;

public interface BookingService {

	FlightBooking findBookingById(Long id);

	FlightBooking addBooking(BookingCriteria bookingCriteria);

	List<FlightBooking> findBookingByPassengerId(Long passengerId);

}
