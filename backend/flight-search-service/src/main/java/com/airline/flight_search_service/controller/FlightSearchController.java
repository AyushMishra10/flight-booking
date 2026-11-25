package com.airline.flight_search_service.controller;

import com.airline.flight_search_service.dto.FlightResponse;
import com.airline.flight_search_service.service.FlightSearchService;
import org.jspecify.annotations.NullMarked;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@CrossOrigin(origins = "http://localhost:4200")
@NullMarked
public class FlightSearchController {

    private final FlightSearchService flightSearchService;

    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @GetMapping("/search")
    public List<FlightResponse> searchFlights(@RequestParam String origin,
                                              @RequestParam String destination){
    return flightSearchService.searchFlights(origin, destination);
    }
}
