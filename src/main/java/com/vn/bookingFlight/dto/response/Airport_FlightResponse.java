package com.vn.bookingFlight.dto.response;

import java.sql.Date;

import lombok.Data;

@Data
public class Airport_FlightResponse {
    private Long id;
    private String airportName;
    private String flightCode;
    private Date arrivalDate;
    private Date departureDate;
}
