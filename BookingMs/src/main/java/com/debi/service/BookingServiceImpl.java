package com.debi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.debi.exception.BsnsObjException;
import com.debi.model.Flight;
import com.debi.model.FlightBooking;
import com.debi.repository.BookingRepository;
import com.debi.util.BookingCriteria;
import com.debi.util.FlightInfo;
import com.debi.util.Passenger;
import com.debi.util.RestTemplateResponseErrorHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository repo;
	
	@Autowired
	RestTemplateBuilder builder;
	
	@Autowired
	EurekaClient eurekaClient;

	@Override
	public FlightBooking findBookingById(Long id) {
		return repo.findById(id).orElseThrow(() -> new BsnsObjException("No such booking exist.", HttpStatus.NOT_FOUND));
	}

	@Override
	public FlightBooking addBooking(BookingCriteria bookingCriteria) {
		// TODO Auto-generated method stub
		FlightBooking booking = new FlightBooking();
		
		//RestTemplate restTemplate= builder.build();
		//booking.setPassengerId(getPassengerIdFromPassengerMs(restTemplate, bookingCriteria.getPassengerMailId()));
		RestTemplate restTemplate = builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
		booking.setPassengerId(getPassengerIdFromPassengerMsEureka(restTemplate, bookingCriteria.getPassengerMailId()));
		
		//FlightInfo flightInfo = getFlightInfoFromFlightMs(restTemplate, 6l);
		//System.out.println(bookingCriteria);
		FlightInfo flightInfo = getFlightInfoFromFlightMsEureka(restTemplate, bookingCriteria.getFlightId());
		Flight flightEntity = new Flight();
		flightEntity.setArrivalAirport(flightInfo.getArrivalAirport());
		flightEntity.setDepartureAirport(flightInfo.getDepartureAirport());
		flightEntity.setDepartureDate(bookingCriteria.getFlightDepartureDate());
		flightEntity.setFlightInfoId(flightInfo.getId());
		booking.setFlight(flightEntity);
		
		return repo.save(booking);
	}
	
	@Override
	public List<FlightBooking> findBookingByPassengerId(Long passengerId) {
		return repo.findByPassengerId(passengerId);
	}
	
	private Long getPassengerIdFromPassengerMsEureka(RestTemplate restTemplate, String passengerMailId) {
		InstanceInfo client = eurekaClient.getNextServerFromEureka("passenger-ms", false);
		System.out.println(client.getInstanceId());
		String baseURL = client.getHomePageUrl();
		Passenger passengerInfo = null;
		try {
		   passengerInfo = restTemplate.getForObject(baseURL + "/passengerApp/api/v1/passengerInfo/mail/{mailId}", Passenger.class, passengerMailId);
		}catch (HttpStatusCodeException e) {
			// TODO: handle exception
		}
		if (passengerInfo == null) {
			throw new BsnsObjException("Passenger does not exist!", HttpStatus.NOT_FOUND);
		}
		System.out.println(passengerInfo);
		return passengerInfo.getId();
		
	}
	
	private FlightInfo getFlightInfoFromFlightMsEureka(RestTemplate restTemplate, Long flightId) {
		InstanceInfo client = eurekaClient.getNextServerFromEureka("flight-ms", false);
		String baseURL = client.getHomePageUrl();
		System.err.println(client.getInstanceId());
		FlightInfo flightInfo = restTemplate.getForObject(baseURL + "/flightApp/api/v1/flightInfo/{id}", FlightInfo.class, flightId);
		if (flightInfo == null) {
			throw new BsnsObjException("Flight does not exist!", HttpStatus.NOT_FOUND);
		}
		System.out.println(flightInfo);
		
		return flightInfo;
		
	}

	private Long getPassengerIdFromPassengerMs(RestTemplate restTemplate, String passengerMailId) {
		Passenger passengerInfo = restTemplate.getForObject("http://localhost:8082/api/v1/passengerInfo/mail/{mailId}", Passenger.class, passengerMailId);
		if (passengerInfo == null) {
			throw new BsnsObjException("Passenger does not exist!", HttpStatus.NOT_FOUND);
		}
		System.out.println(passengerInfo);
		return passengerInfo.getId();
		//ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/api/v1/passengerInfo/mail/{mailId}", HttpMethod.GET, null, String.class, passengerMailId);		
	}
	
	private FlightInfo getFlightInfoFromFlightMs(RestTemplate restTemplate, Long flightId) {
		FlightInfo flightInfo = restTemplate.getForObject("http://localhost:8080/api/v1/flightInfo/{id}", FlightInfo.class, flightId);
		if (flightInfo == null) {
			throw new BsnsObjException("Flight does not exist!", HttpStatus.NOT_FOUND);
		}
		System.out.println(flightInfo);
		
		return flightInfo;
		//ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/api/v1/passengerInfo/mail/{mailId}", HttpMethod.GET, null, String.class, passengerMailId);		
	}

	
	//String url ="http://localhost:8080/api/v1/flightInfo/find/";
	
//	JSONObject request = new JSONObject();
//	request.put("departureAirport", bookingCriteria.getFlightDepartureAirport());
//	request.put("arrivalAirport", bookingCriteria.getFlightArrivalAirport());
//	request.put("departureDate", bookingCriteria.getFlightDepartureDate());
//	FlightCriteria flightCriteria = new FlightCriteria();
//	flightCriteria.setArrivalAirport(bookingCriteria.getFlightArrivalAirport());
//	flightCriteria.setDepartureAirport(bookingCriteria.getFlightDepartureAirport());
//	flightCriteria.setDepartureDate(bookingCriteria.getFlightDepartureDate());
//	System.out.println(flightCriteria);
//    //HttpEntity<FlightCriteria> requestEntity = new HttpEntity<FlightCriteria>(flightCriteria);
//    
//    HttpEntity<String> requestEntity = new HttpEntity<String>("{\n"
//    		+ "    \"departureAirport\" : \"IXB\",\n"
//    		+ "    \"arrivalAirport\" : \"MAA\",\n"
//    		+ "    \"departureDate\" : \"2021-10-22\"\n"
//    		+ "}");
//    ResponseEntity<Long> flightInfo = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Long.class);
	
    //System.out.println(pas);
    
    
//    Map<String, String> map = new HashMap<>();
//    map.put("departureAirport", bookingCriteria.getFlightDepartureAirport());
//    map.put("arrivalAirport", bookingCriteria.getFlightArrivalAirport());
//    map.put("departureDate", bookingCriteria.getFlightDepartureDate().toString());
//    System.out.println(map);
//    ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class, map);
//    System.out.println(response);
    
    
//    restTemplate = new RestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.APPLICATION_JSON);
//    JSONObject jsonObject = new JSONObject();
//    jsonObject.put("departureAirport", bookingCriteria.getFlightDepartureAirport());
//    jsonObject.put("arrivalAirport", bookingCriteria.getFlightArrivalAirport());
//    jsonObject.put("departureDate", bookingCriteria.getFlightDepartureDate().toString());
//    
//    HttpEntity<String> request = 
//    	      new HttpEntity<String>(jsonObject.toString(), headers);
//    String personResultAsJsonStr = 
//    	      restTemplate.getForObject(url, String.class, request);
//    	    //JsonNode root = objectMapper.readTree(personResultAsJsonStr);
//    System.out.println(personResultAsJsonStr);
//	return null;//repo.save(booking);

}
