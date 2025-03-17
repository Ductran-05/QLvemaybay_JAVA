package com.vn.bookingFlight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.domain.TaiKhoan;
import com.vn.bookingFlight.dto.request.TaiKhoanRequest;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.TaiKhoanResponse;
import com.vn.bookingFlight.service.TaiKhoanService;

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
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<TaiKhoanResponse>> getTaiKhoan(@PathVariable("id") Long id) {
        APIResponse<TaiKhoanResponse> apiResponse = APIResponse.<TaiKhoanResponse>builder()
                .Code(200)
                .Message("Get account by id")
                .data(taiKhoanService.getTaiKhoanById(id))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<TaiKhoanResponse>>> getAllTaiKhoans() {
        APIResponse<List<TaiKhoanResponse>> apiResponse = APIResponse.<List<TaiKhoanResponse>>builder()
                .Code(200)
                .Message("Get all accounts")
                .data(taiKhoanService.getAllTaiKhoans())
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<APIResponse<TaiKhoanResponse>> createTaiKhoan(@RequestBody TaiKhoanRequest request) {
        APIResponse<TaiKhoanResponse> apiResponse = APIResponse.<TaiKhoanResponse>builder()
                .Code(201)
                .Message("Create account")
                .data(taiKhoanService.createTaiKhoan(request))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<TaiKhoanResponse>> updateTaiKhoan(@PathVariable("id") Long id,
            @RequestBody TaiKhoanRequest request) {
        APIResponse<TaiKhoanResponse> apiResponse = APIResponse.<TaiKhoanResponse>builder()
                .Code(200)
                .Message("Update account by id")
                .data(taiKhoanService.updateTaiKhoan(id, request))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteTaiKhoan(@PathVariable("id") Long id) {
        APIResponse<Void> apiResponse = APIResponse.<Void>builder()
                .Code(200)
                .Message("Delete account by id")
                .build();
        taiKhoanService.deleteTaiKhoan(id);
        return ResponseEntity.ok().body(apiResponse);
    }

}
