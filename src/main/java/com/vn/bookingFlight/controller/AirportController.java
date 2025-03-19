package com.vn.bookingFlight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.dto.request.AirportRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.AirportResponse;
import com.vn.bookingFlight.service.AirportService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping()
    public ResponseEntity<APIResponse<List<AirportResponse>>> getAllAirports() {
        APIResponse<List<AirportResponse>> apiResponse = APIResponse.<List<AirportResponse>>builder()
                .Code(200)
                .Message("Get all airports")
                .data(airportService.getAllAirports())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<AirportResponse>> getAirportByID(@PathVariable("id") Long id) {
        APIResponse<AirportResponse> apiResponse = APIResponse.<AirportResponse>builder()
                .Code(200)
                .Message("Get airport by id")
                .data(airportService.getAirportById(id))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<APIResponse<AirportResponse>> createAirport(@RequestBody AirportRequest request) {
        APIResponse<AirportResponse> apiResponse = APIResponse.<AirportResponse>builder()
                .Code(201)
                .Message("Create airport")
                .data(airportService.createAirport(request))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<AirportResponse>> updateAirport(@PathVariable("id") Long id,
            @RequestBody AirportRequest request) {
        APIResponse<AirportResponse> apiResponse = APIResponse.<AirportResponse>builder()
                .Code(200)
                .Message("Update airport by id")
                .data(airportService.updateAirport(id, request))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteAirport(@PathVariable("id") Long id) {
        APIResponse<Void> apiResponse = APIResponse.<Void>builder()
                .Code(200)
                .Message("Delete airport by id")
                .build();
        airportService.deleteAirport(id);
        return ResponseEntity.ok().body(apiResponse);
    }

}
