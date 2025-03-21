package com.vn.bookingFlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.bookingFlight.domain.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
