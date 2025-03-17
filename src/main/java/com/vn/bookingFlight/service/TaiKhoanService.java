package com.vn.bookingFlight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.vn.bookingFlight.BookingFlightApplication;
import com.vn.bookingFlight.Exception.AppException;
import com.vn.bookingFlight.Exception.ErrorCode;
import com.vn.bookingFlight.Exception.GlobalException;
import com.vn.bookingFlight.domain.TaiKhoan;
import com.vn.bookingFlight.dto.request.TaiKhoanRequest;
import com.vn.bookingFlight.dto.response.TaiKhoanResponse;
import com.vn.bookingFlight.mapper.TaiKhoanMapper;
import com.vn.bookingFlight.repository.TaiKhoanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaiKhoanService {

    private final BookingFlightApplication bookingFlightApplication;
    private final TaiKhoanRepository taiKhoanRepository;
    private final TaiKhoanMapper taiKhoanMapper;

    public TaiKhoanResponse getTaiKhoanById(Long id) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED));
        return taiKhoanMapper.toTaiKhoanResponse(taiKhoan);
    }

    public List<TaiKhoanResponse> getAllTaiKhoans() {
        return taiKhoanRepository.findAll().stream()
                .map(taiKhoanMapper::toTaiKhoanResponse)
                .collect(Collectors.toList());
    }

    public TaiKhoanResponse createTaiKhoan(TaiKhoanRequest request) {
        if (taiKhoanRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        return taiKhoanMapper.toTaiKhoanResponse(taiKhoanRepository.save(taiKhoanMapper.toTaiKhoan(request)));
    }

    public TaiKhoanResponse updateTaiKhoan(Long id, TaiKhoanRequest request) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED));
        taiKhoanMapper.updateTaiKhoan(taiKhoan, request);
        return taiKhoanMapper.toTaiKhoanResponse(taiKhoanRepository.save(taiKhoan));
    }

    public void deleteTaiKhoan(Long id) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED));
        taiKhoanRepository.delete(taiKhoan);
    }

}
