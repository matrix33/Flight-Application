package com.debi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.debi.model.FlightBooking;

@Repository
public interface BookingRepository extends CrudRepository<FlightBooking, Long> {

	List<FlightBooking> findByPassengerId(Long passengerId);


}
