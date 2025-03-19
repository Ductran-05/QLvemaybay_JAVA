package com.vn.bookingFlight.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeatClassRequest {
    private String name;
    private Double price;
    private String description;
}
