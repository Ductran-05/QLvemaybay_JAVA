package com.vn.bookingFlight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vn.bookingFlight.Exception.AppException;
import com.vn.bookingFlight.Exception.ErrorCode;
import com.vn.bookingFlight.domain.SeatClass;
import com.vn.bookingFlight.dto.request.SeatClassRequest;
import com.vn.bookingFlight.dto.response.SeatClassResponse;
import com.vn.bookingFlight.mapper.SeatClassMapper;
import com.vn.bookingFlight.repository.SeatClassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatClassService {

    private final SeatClassRepository seatClassRepository;
    private final SeatClassMapper seatClassMapper;

    public List<SeatClassResponse> getAllSeatClass() {
        return seatClassRepository.findAll().stream()
                .map(seatClassMapper::toSeatClassResponse)
                .collect(Collectors.toList());
    }

    public SeatClassResponse getSeatClassById(Long id) {
        return seatClassRepository.findById(id)
                .map(seatClassMapper::toSeatClassResponse)
                .orElseThrow(() -> new AppException(ErrorCode.SEATCLASS_NOT_EXISTED));
    }

    public SeatClassResponse createSeatClass(SeatClassRequest request) {
        if (seatClassRepository.findSeatClassByName(request.getName()) != null) {
            throw new AppException(ErrorCode.SEATCLASS_NAME_EXISTED);
        }
        return seatClassMapper.toSeatClassResponse(seatClassRepository.save(seatClassMapper.toSeatClass(request)));
    }

    public SeatClassResponse updateSeatClass(Long id, SeatClassRequest request) {
        SeatClass seatClass = seatClassRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SEATCLASS_NOT_EXISTED));
        // if (seatClassRepository.findSeatClassByName(request.getName()) != null) {
        // throw new AppException(ErrorCode.SEATCLASS_NAME_EXISTED);
        // }
        seatClassMapper.updateSeatClass(seatClass, request);
        return seatClassMapper.toSeatClassResponse(seatClassRepository.save(seatClass));
    }

    public void deleteSeatClass(Long id) {
        if (seatClassRepository.findById(id) != null) {
            seatClassRepository.deleteById(id);
        }
    }

}
