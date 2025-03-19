package com.vn.bookingFlight.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.dto.request.PlaneRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.PlaneResponse;
import com.vn.bookingFlight.service.PlaneService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/planes")
@RequiredArgsConstructor
public class PlaneController {
    private final PlaneService planeService;

    @GetMapping()
    public ResponseEntity<APIResponse<List<PlaneResponse>>> getAllPlanes() {
        APIResponse<List<PlaneResponse>> apiResponse = APIResponse.<List<PlaneResponse>>builder()
                .Code(200)
                .Message("Get all planes")
                .data(planeService.getAllPlanes())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<PlaneResponse>> getPlaneByID(@PathVariable("id") Long id) {
        APIResponse<PlaneResponse> apiResponse = APIResponse.<PlaneResponse>builder()
                .Code(200)
                .Message("Get plane by id")
                .data(planeService.getPlaneById(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<APIResponse<PlaneResponse>> postMethodName(@RequestBody PlaneRequest request) {
        APIResponse<PlaneResponse> apiResponse = APIResponse.<PlaneResponse>builder()
                .Code(201)
                .Message("Create plane")
                .data(planeService.createPlane(request))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<PlaneResponse>> updatePlane(@PathVariable("id") Long id,
            @RequestBody PlaneRequest request) {
        APIResponse<PlaneResponse> apiResponse = APIResponse.<PlaneResponse>builder()
                .Code(200)
                .Message("Update plane by id")
                .data(planeService.updatePlane(id, request))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deletePlane(@PathVariable("id") Long id) {
        APIResponse<Void> apiResponse = APIResponse.<Void>builder()
                .Code(200)
                .Message("Delete plane by id")
                .build();
        planeService.deletePlane(id);
        return ResponseEntity.ok().body(apiResponse);
    }
}
