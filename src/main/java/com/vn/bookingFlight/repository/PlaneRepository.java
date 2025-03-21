package com.vn.bookingFlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.bookingFlight.domain.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

}
