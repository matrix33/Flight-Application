package com.debi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.debi.model.Passenger;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {

	Passenger findByEmail(String mailId);

}
