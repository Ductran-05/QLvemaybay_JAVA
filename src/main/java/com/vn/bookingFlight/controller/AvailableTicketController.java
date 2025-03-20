package com.vn.bookingFlight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.dto.request.AvailableTicketRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.AvailableTicketResponse;
import com.vn.bookingFlight.service.AvailableTicketService;

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
@RequestMapping("/Ticket")
@RequiredArgsConstructor
public class AvailableTicketController {
    private final AvailableTicketService availableTicketService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<AvailableTicketResponse>> getTicketById(@PathVariable("id") Long id) {
        APIResponse<AvailableTicketResponse> apiResponse = APIResponse.<AvailableTicketResponse>builder()
                .Code(200)
                .Message("Get ticket by id")
                .data(availableTicketService.findById(id))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<AvailableTicketResponse>>> getAllAvailableTickets() {
        APIResponse<List<AvailableTicketResponse>> apiResponse = APIResponse.<List<AvailableTicketResponse>>builder()
                .Code(200)
                .Message("Get all Tickets")
                .data(availableTicketService.findAllAvailableTickets())
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping("/query/{flight}")
    public ResponseEntity<APIResponse<List<AvailableTicketResponse>>> getAllAvailableTicketsByFlightId(@PathVariable("flight") long flightId) {
        APIResponse<List<AvailableTicketResponse>> apiResponse = APIResponse.<List<AvailableTicketResponse>>builder()
                .Code(200)
                .Message("Get all Ticket by FlightID")
                .data(availableTicketService.findAllAvailableTicketsByFlight_id(flightId))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<AvailableTicketResponse>> createAvailableTicket(@RequestBody AvailableTicketRequest request) {
        APIResponse<AvailableTicketResponse> apiResponse = APIResponse.<AvailableTicketResponse>builder()
                .Code(201)
                .Message("Create available ticket")
                .data(availableTicketService.createAvailableTicket(request))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<APIResponse<AvailableTicketResponse>> updateAvailableTicket(@PathVariable("id") Long id,
//                                                                                      @RequestBody AvailableTicketRequest request) {
//        APIResponse<AvailableTicketResponse> apiResponse = APIResponse.<AvailableTicketResponse>builder()
//                .Code(200)
//                .Message("Update available ticket by id")
//                .data(availableTicketService.updateAvailableTicket(id, request))
//                .build();
//        return ResponseEntity.ok().body(apiResponse);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteAvailableTicket(@PathVariable("id") Long id) {
        APIResponse<Void> apiResponse = APIResponse.<Void>builder()
                .Code(200)
                .Message("Delete available ticket by id")
                .build();
        availableTicketService.deleteById(id);
        return ResponseEntity.ok().body(apiResponse);
    }
}