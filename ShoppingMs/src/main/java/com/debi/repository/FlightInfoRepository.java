package com.debi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.debi.model.Flight;

@Repository
public interface FlightInfoRepository extends CrudRepository<Flight, Long> {

	@Query("SELECT f FROM Flight f where f.departureDayinWeek like %?1% and f.departureAirport = ?2 and f.arrivalAirport = ?3")
	List<Flight> getFlightByDateAirport(int dayOfWeek, String departureAirport, String arrivalAirport);
}
