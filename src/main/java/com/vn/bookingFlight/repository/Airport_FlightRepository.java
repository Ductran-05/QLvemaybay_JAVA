package com.vn.bookingFlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.bookingFlight.domain.Airport_Flight;

@Repository
public interface Airport_FlightRepository extends JpaRepository<Airport_Flight, Long> {

}
