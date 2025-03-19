package com.vn.bookingFlight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.dto.request.SeatClassRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.SeatClassResponse;
import com.vn.bookingFlight.service.SeatClassService;

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
@RequestMapping("/seatclasses")
@RequiredArgsConstructor
public class SeatClassController {
    private final SeatClassService seatClassService;

    @GetMapping()
    public ResponseEntity<APIResponse<List<SeatClassResponse>>> getAllSeatClasses() {
        APIResponse<List<SeatClassResponse>> apiResponse = APIResponse.<List<SeatClassResponse>>builder()
                .Code(200)
                .Message("Get all seat classes")
                .data(seatClassService.getAllSeatClass())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<SeatClassResponse>> getSeatClassByID(@PathVariable("id") Long id) {
        APIResponse<SeatClassResponse> apiResponse = APIResponse.<SeatClassResponse>builder()
                .Code(200)
                .Message("Get seat class by id")
                .data(seatClassService.getSeatClassById(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<APIResponse<SeatClassResponse>> createSeatClass(@RequestBody SeatClassRequest request) {
        APIResponse<SeatClassResponse> apiResponse = APIResponse.<SeatClassResponse>builder()
                .Code(201)
                .Message("Create seat class")
                .data(seatClassService.createSeatClass(request))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<SeatClassResponse>> updateSeatClass(@PathVariable("id") Long id,
            @RequestBody SeatClassRequest entity) {
        APIResponse<SeatClassResponse> apiResponse = APIResponse.<SeatClassResponse>builder()
                .Code(200)
                .Message("Update seat class by id")
                .data(seatClassService.updateSeatClass(id, entity))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteSeatClass(@PathVariable("id") Long id) {
        APIResponse<Void> apiResponse = APIResponse.<Void>builder()
                .Code(200)
                .Message("Delete seat class by id")
                .build();
        seatClassService.deleteSeatClass(id);
        return ResponseEntity.ok(apiResponse);
    }

}
