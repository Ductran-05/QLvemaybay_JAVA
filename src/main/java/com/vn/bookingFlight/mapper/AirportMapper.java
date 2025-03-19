package com.vn.bookingFlight.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.vn.bookingFlight.domain.Airport;
import com.vn.bookingFlight.dto.request.AirportRequest;
import com.vn.bookingFlight.dto.response.AirportResponse;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    Airport toAirport(AirportRequest request);

    AirportResponse toAirportResponse(Airport airport);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAirport(@MappingTarget Airport airport, AirportRequest request);
}
