package com.vn.bookingFlight.dto.request;

import lombok.Data;

import java.sql.Date;

@Data
public class AvailableTicketRequest {
    private Long flightId;
    private Long seatClassId;
    private String seatNum;
    private Long customerId;
    private Long bookingFlightId;
}
