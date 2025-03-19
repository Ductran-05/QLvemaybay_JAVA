package com.vn.bookingFlight.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vn.bookingFlight.Exception.AppException;
import com.vn.bookingFlight.Exception.ErrorCode;
import com.vn.bookingFlight.domain.Plane;
import com.vn.bookingFlight.dto.request.PlaneRequest;
import com.vn.bookingFlight.dto.response.PlaneResponse;
import com.vn.bookingFlight.mapper.PlaneMapper;
import com.vn.bookingFlight.repository.PlaneRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaneService {
    private final PlaneRepository planeRepository;
    private final PlaneMapper planeMapper;

    public List<PlaneResponse> getAllPlanes() {
        return planeRepository.findAll().stream()
                .map(planeMapper::toPlaneResponse)
                .collect(Collectors.toList());
    }

    public PlaneResponse getPlaneById(Long id) {
        return planeRepository.findById(id)
                .map(planeMapper::toPlaneResponse)
                .orElseThrow(() -> new AppException(ErrorCode.PLANE_NOT_EXISTED));
    }

    public PlaneResponse createPlane(PlaneRequest request) {
        return planeMapper.toPlaneResponse(planeRepository.save(planeMapper.toPlane(request)));
    }

    public PlaneResponse updatePlane(Long id, PlaneRequest request) {
        Plane plane = planeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PLANE_NOT_EXISTED));
        planeMapper.updatePlane(plane, request);
        return planeMapper.toPlaneResponse(planeRepository.save(plane));
    }

    public void deletePlane(Long id) {
        planeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PLANE_NOT_EXISTED));
        planeRepository.deleteById(id);
    }

}
