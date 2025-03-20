package com.vn.bookingFlight.repository;

import com.vn.bookingFlight.domain.AvailableTicket;
import com.vn.bookingFlight.dto.response.AvailableTicketResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableTicketRepository extends JpaRepository<AvailableTicket,Long> {
    List<AvailableTicket> findAllAvailableTicketsByFlight_id(long flightId);
}
