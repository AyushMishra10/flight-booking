package com.airline.flight_search_service;

import com.airline.flight_search_service.service.FlightSearchService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(FlightSearchService service){
		return args -> service.seedData();
	}
}
