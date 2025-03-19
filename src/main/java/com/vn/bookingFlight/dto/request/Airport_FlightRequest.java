package com.vn.bookingFlight.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class Airport_FlightRequest {
    private Long airportId;
    private Long flightId;
    private Date arrivalDate;
    private Date departureDate;
}
