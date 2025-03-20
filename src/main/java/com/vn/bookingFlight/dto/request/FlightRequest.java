package com.vn.bookingFlight.dto.request;

import lombok.Data;
import java.util.Date;

@Data
public class FlightRequest {
    private Long id;
    private Long planeId;
    private Long departureAirPortId;
    private Long arrivalAirPortId;
    private Date departureDate;
    private Date arrivalDate;
    private Double price;
}