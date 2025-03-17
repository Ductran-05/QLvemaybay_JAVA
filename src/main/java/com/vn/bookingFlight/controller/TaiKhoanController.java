package com.vn.bookingFlight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vn.bookingFlight.domain.TaiKhoan;
import com.vn.bookingFlight.dto.response.APIResponse;
import com.vn.bookingFlight.dto.response.TaiKhoanResponse;
import com.vn.bookingFlight.service.TaiKhoanService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;

    // @GetMapping("/{id}")
    // public ResponseEntity<APIResponse<TaiKhoanResponse>>
    // getTaiKhoan(@PathVariable Long id) {
    // TaiKhoan taiKhoan = taiKhoanService.findById(id);
    // return ResponseEntity.ok(new APIResponse<>(new TaiKhoanResponse(taiKhoan)));
    // }

}
