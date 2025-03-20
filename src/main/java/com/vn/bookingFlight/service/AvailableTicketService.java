package com.vn.bookingFlight.service;

import com.vn.bookingFlight.Exception.AppException;
import com.vn.bookingFlight.Exception.ErrorCode;
import com.vn.bookingFlight.domain.AvailableTicket;
import com.vn.bookingFlight.domain.Flight;
import com.vn.bookingFlight.domain.SeatClass;
import com.vn.bookingFlight.dto.request.AvailableTicketRequest;
import com.vn.bookingFlight.dto.response.AvailableTicketResponse;
import com.vn.bookingFlight.mapper.AvailableTicketMapper;
import com.vn.bookingFlight.repository.AvailableTicketRepository;
import com.vn.bookingFlight.repository.FlightRepository;
import com.vn.bookingFlight.repository.SeatClassRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailableTicketService {
    private final AvailableTicketMapper availableTicketMapper;
    private final AvailableTicketRepository availableTicketRepository;
    private final FlightRepository flightRepository; // Add this
    private final SeatClassRepository seatClassRepository; // Add this

    public AvailableTicketResponse findById(Long id) {
        return availableTicketRepository.findById(id)
                .map(availableTicketMapper::toAvailableTicketResponse) // Use the instance
                .orElseThrow(() -> new EntityNotFoundException(AvailableTicket.class.getName()));
    }

    public List<AvailableTicketResponse> findAllAvailableTickets() {
        return availableTicketRepository.findAll().stream()
                .map(availableTicketMapper::toAvailableTicketResponse)
                .collect(Collectors.toList());
    }

    public List<AvailableTicketResponse> findAllAvailableTicketsByFlight_id(long flightId) {
        return availableTicketRepository.findAllAvailableTicketsByFlight_id(flightId).stream()
                .map(availableTicketMapper::toAvailableTicketResponse)
                .collect(Collectors.toList());
    }

    public void  deleteById(Long id) {
        AvailableTicket ticket = availableTicketRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TICKET_NOT_EXISTED));
        availableTicketRepository.delete(ticket);
    }
    public AvailableTicketResponse createAvailableTicket(AvailableTicketRequest request) {
        Flight flight = flightRepository.findById(request.getFlightId())
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with ID: " + request.getFlightId()));
        SeatClass seatClass = seatClassRepository.findById(request.getSeatClassId())
                .orElseThrow(() -> new EntityNotFoundException("SeatClass not found with ID: " + request.getSeatClassId()));

        AvailableTicket ticket = new AvailableTicket();
        ticket.setFlight(flight);
        ticket.setSeatClass(seatClass);
        ticket.setSeatNum(request.getSeatNum());

        AvailableTicket savedTicket = availableTicketRepository.save(ticket);
        return availableTicketMapper.toAvailableTicketResponse(savedTicket);
    }
    public AvailableTicketResponse updateAvailableTicket(long id, AvailableTicketRequest availableTicketRequest) {
        AvailableTicket ticket = availableTicketRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TICKET_NOT_EXISTED));
        availableTicketMapper.updateAvailableTicket(ticket, availableTicketRequest);
        return availableTicketMapper.toAvailableTicketResponse(availableTicketRepository.save(ticket));
    }
}
