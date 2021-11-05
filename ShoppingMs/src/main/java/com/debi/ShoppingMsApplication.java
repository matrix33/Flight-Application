package com.debi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
//@RibbonClient(name = "flight-ms")
public class ShoppingMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingMsApplication.class, args);
	}

}
