package com.vn.bookingFlight.dto.response;

import lombok.Data;

@Data
public class SeatClassResponse {
    private Long _id;
    private String name;
    private Double price;
    private String description;
}
