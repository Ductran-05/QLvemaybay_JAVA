package com.vn.bookingFlight.dto.request;

import lombok.Data;

@Data
public class AirportRequest {
    private String name;
    private String country;
    private String city;
}
