package com.vn.bookingFlight.service;

import org.springframework.stereotype.Service;

import com.vn.bookingFlight.repository.TaiKhoanRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class TaiKhoanService {
    private final TaiKhoanRepository taiKhoanRepository;

}
