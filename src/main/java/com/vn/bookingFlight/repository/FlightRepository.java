package com.vn.bookingFlight.repository;

import com.vn.bookingFlight.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository  extends JpaRepository<Flight,Long> {

}