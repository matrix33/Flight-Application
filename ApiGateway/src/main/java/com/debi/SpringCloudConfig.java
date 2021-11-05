package com.debi;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/flightApp/**")
                        .uri("lb://flight-ms"))
                .route(r -> r.path("/passengerApp/**")
                        .uri("lb://passenger-ms"))
                .route(r -> r.path("/bookingApp/**")
                        .uri("lb://passenger-ms"))
                .build();
    }

}
