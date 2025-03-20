package com.vn.bookingFlight.controller;


import com.vn.bookingFlight.domain.Flight;
import com.vn.bookingFlight.dto.request.FlightRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.AirportResponse;
import com.vn.bookingFlight.dto.response.FlightResponse;
import com.vn.bookingFlight.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Flight")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<APIResponse<List<FlightResponse>>> getAllFlights() {
        APIResponse<List<FlightResponse>> apiResponse = APIResponse.<List<FlightResponse>>builder()
                .Code(200)
                .Message("Success")
                .data(flightService.findAllFlights())
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<FlightResponse>> getFlightById(@PathVariable long id) {
        APIResponse<FlightResponse> apiResponse = APIResponse.<FlightResponse>builder()
                .Code(200)
                .Message("Success")
                .data(flightService.findById(id))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<FlightResponse>> createFlight(@RequestBody FlightRequest flightRequest) {
        APIResponse<FlightResponse> apiResponse = APIResponse.<FlightResponse>builder()
                .Code(200)
                .Message("Success")
                .data(flightService.createFlight(flightRequest))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }
}
