package com.vn.bookingFlight.service;


import com.vn.bookingFlight.Exception.AppException;
import com.vn.bookingFlight.Exception.ErrorCode;
import com.vn.bookingFlight.domain.Airport;
import com.vn.bookingFlight.domain.Flight;
import com.vn.bookingFlight.domain.Plane;
import com.vn.bookingFlight.dto.request.FlightRequest;
import com.vn.bookingFlight.dto.response.FlightResponse;
import com.vn.bookingFlight.mapper.FlightMapper;
import com.vn.bookingFlight.repository.AccountRepository;
import com.vn.bookingFlight.repository.AirportRepository;
import com.vn.bookingFlight.repository.FlightRepository;
import com.vn.bookingFlight.repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final PlaneRepository planeRepository; // Add this
    private final AirportRepository airportRepository; // Add this

    public FlightResponse findById(Long id) {
        return flightRepository.findById(id)
                .map(flightMapper::toFlightResponse)
                .orElseThrow(() -> new AppException(ErrorCode.FLIGHT_NOT_EXISTED));
    }
    public List<FlightResponse> findAllFlights() {
        return flightRepository.findAll().stream()
                .map(flightMapper::toFlightResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public FlightResponse createFlight(FlightRequest flightRequest) {
        // Fetch related entities
        Plane plane = flightRequest.getPlaneId() != null ?
                planeRepository.findById(flightRequest.getPlaneId())
                        .orElseThrow(() -> new AppException(ErrorCode.PLANE_NOT_EXISTED)) : null;
        Airport departureAirport = airportRepository.findById(flightRequest.getDepartureAirPortId())
                .orElseThrow(() -> new AppException(ErrorCode.AIRPORT_NOT_EXISTED));
        Airport arrivalAirport = airportRepository.findById(flightRequest.getArrivalAirPortId())
                .orElseThrow(() -> new AppException(ErrorCode.AIRPORT_NOT_EXISTED));

        // Create Flight entity manually
        Flight flight = new Flight();
        flight.setPlane(plane); // Can be null if planeId is optional
        flight.setDepartureAirPort(departureAirport);
        flight.setAirPort(arrivalAirport);
        flight.setDepartureDate(flightRequest.getDepartureDate());
        flight.setArrivalDate(flightRequest.getArrivalDate());
        flight.setPrice(flightRequest.getPrice());

        // Save and map to response
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.toFlightResponse(savedFlight);
    }
}
