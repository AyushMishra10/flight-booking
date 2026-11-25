package com.airline.flight_search_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FlightResponse(
    String id,String flightNumber,String origin,String destination,
    LocalDateTime departureTime,
    BigDecimal price)
{}
