package com.airline.flight_search_service.dto;

import java.time.LocalDate;

public record FlightSearchRequest(String origin, String destination, LocalDate date) { }
