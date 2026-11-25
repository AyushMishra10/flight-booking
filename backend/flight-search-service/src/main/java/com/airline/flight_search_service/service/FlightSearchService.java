package com.airline.flight_search_service.service;

import com.airline.flight_search_service.dto.FlightResponse;
import com.airline.flight_search_service.entity.Flight;
import com.airline.flight_search_service.repository.FlightRepository;
import org.jspecify.annotations.NullMarked;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@NullMarked
public class FlightSearchService {

    private final FlightRepository flightRepository;

    //constructor injection (Best practice)
    public FlightSearchService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightResponse> searchFlights(String origin, String destination){
        List<Flight> flights = flightRepository.findByOriginIgnoreCaseAndDestinationIgnoreCase(origin, destination);

        //map entity to record in java 21 way
        return flights.stream().map(flight -> new FlightResponse(
                flight.getId(),
                flight.getFlightNumber(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getPrice()
        ))
        .toList();
    }

    // Helper to seed data on startup for testing
    public void seedData() {
        if (flightRepository.count() == 0) {
            flightRepository.saveAll(List.of(
                    new Flight("AA101", "KUL", "DMK", LocalDateTime.now().plusDays(2), new BigDecimal("150.00"), 45),
                    new Flight("AA102", "KUL", "DMK", LocalDateTime.now().plusDays(2).plusHours(4), new BigDecimal("180.50"), 12),
                    new Flight("AA205", "DMK", "KUL", LocalDateTime.now().plusDays(5), new BigDecimal("160.00"), 30)
            ));
        }
    }
}
