package com.vn.bookingFlight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.vn.bookingFlight.domain.Plane;
import com.vn.bookingFlight.dto.request.PlaneRequest;
import com.vn.bookingFlight.dto.response.PlaneResponse;

@Mapper(componentModel = "spring")
public interface PlaneMapper {
    Plane toPlane(PlaneRequest request);

    PlaneResponse toPlaneResponse(Plane entity);

    void updatePlane(@MappingTarget Plane plane, PlaneRequest request);
}
