package com.vn.bookingFlight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.vn.bookingFlight.domain.SeatClass;
import com.vn.bookingFlight.dto.request.SeatClassRequest;
import com.vn.bookingFlight.dto.response.SeatClassResponse;

@Mapper(componentModel = "spring")
public interface SeatClassMapper {
    SeatClass toSeatClass(SeatClassRequest request);

    SeatClassResponse toSeatClassResponse(SeatClass entity);

    void updateSeatClass(@MappingTarget SeatClass seatClass, SeatClassRequest request);
}
