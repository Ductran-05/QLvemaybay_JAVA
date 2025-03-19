package com.vn.bookingFlight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vn.bookingFlight.Exception.AppException;
import com.vn.bookingFlight.Exception.ErrorCode;
import com.vn.bookingFlight.domain.Airport;
import com.vn.bookingFlight.dto.request.AirportRequest;
import com.vn.bookingFlight.dto.response.AirportResponse;
import com.vn.bookingFlight.mapper.AirportMapper;
import com.vn.bookingFlight.repository.AirportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public List<AirportResponse> getAllAirports() {
        return airportRepository.findAll().stream()
                .map(airportMapper::toAirportResponse)
                .collect(Collectors.toList());
    }

    public AirportResponse getAirportById(Long id) {
        return airportRepository.findById(id)
                .map(airportMapper::toAirportResponse)
                .orElseThrow(() -> new AppException(ErrorCode.AIRPORT_NOT_EXISTED));
    }

    public AirportResponse createAirport(AirportRequest request) {
        return airportMapper.toAirportResponse(airportRepository.save(airportMapper.toAirport(request)));
    }

    public AirportResponse updateAirport(Long id, AirportRequest request) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.AIRPORT_NOT_EXISTED));
        airportMapper.updateAirport(airport, request);
        return airportMapper.toAirportResponse(airportRepository.save(airport));
    }
    public void deleteAirport(Long id) {
        airportRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.AIRPORT_NOT_EXISTED));
        airportRepository.deleteById(id);
    }
}
