package com.vn.bookingFlight.dto.response;

import lombok.Data;
import java.util.Date;

@Data
public class FlightResponse {
    private Long id;
    private Long planeId;
    private String planeModel;
    private Long departureAirPortId;
    private String departureAirPortName;
    private Long arrivalAirPortId;
    private String arrivalAirPortName;
    private Date departureDate;
    private Date arrivalDate;
    private Double price;
}