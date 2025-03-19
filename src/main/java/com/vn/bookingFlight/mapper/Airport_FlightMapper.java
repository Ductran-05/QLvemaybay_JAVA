package com.vn.bookingFlight.mapper;

import org.mapstruct.Mapper;

import com.vn.bookingFlight.domain.Airport_Flight;
import com.vn.bookingFlight.dto.request.Airport_FlightRequest;
import com.vn.bookingFlight.dto.response.AirportResponse;

@Mapper(componentModel = "spring")
public interface Airport_FlightMapper {
    Airport_Flight toAiport_Flight(Airport_FlightRequest request);

    AirportResponse toAirportResponse(Airport_Flight entity);
}
