package com.vn.bookingFlight.mapper;

import com.vn.bookingFlight.domain.Flight;
import com.vn.bookingFlight.dto.request.FlightRequest;
import com.vn.bookingFlight.dto.response.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    Flight toFlight(FlightRequest request);

    @Mapping(source = "plane._id", target = "planeId")
    @Mapping(source = "departureAirPort._id", target = "departureAirPortId")
    @Mapping(source = "departureAirPort.name", target = "departureAirPortName")
    @Mapping(source = "airPort._id", target = "arrivalAirPortId")
    @Mapping(source = "airPort.name", target = "arrivalAirPortName")
    FlightResponse toFlightResponse(Flight flight);

    FlightRequest toFlightRequest(Flight flight);
}
