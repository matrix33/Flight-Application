package com.debi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class BookingMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingMsApplication.class, args);
	}

}
