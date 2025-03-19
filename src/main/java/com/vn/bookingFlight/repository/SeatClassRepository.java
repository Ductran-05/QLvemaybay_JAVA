package com.vn.bookingFlight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.bookingFlight.domain.SeatClass;

@Repository
public interface SeatClassRepository extends JpaRepository<SeatClass, Long> {

    SeatClass findSeatClassByName(String name);

}
