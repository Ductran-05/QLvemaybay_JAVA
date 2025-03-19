package com.vn.bookingFlight.dto.response;

import lombok.Data;

@Data
public class AirportResponse {
    private Long _id;
    private String name;
    private String country;
    private String city;
}
