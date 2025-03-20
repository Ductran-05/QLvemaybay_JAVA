package com.vn.bookingFlight.dto.response;

import lombok.Data;

import java.sql.Date;

@Data
public class AvailableTicketResponse {
    private Long id;
    private Long flightId;
    private Long seatClassId;
    private String seatNum;
    private Long customerId;
    private Long bookingFlightId;
}
