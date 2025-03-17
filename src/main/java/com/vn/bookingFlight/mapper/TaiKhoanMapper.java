package com.vn.bookingFlight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.vn.bookingFlight.domain.TaiKhoan;
import com.vn.bookingFlight.dto.request.TaiKhoanRequest;
import com.vn.bookingFlight.dto.response.TaiKhoanResponse;

@Mapper(componentModel = "Spring")
public interface TaiKhoanMapper {
    TaiKhoan toTaiKhoan(TaiKhoanRequest request);

    TaiKhoanResponse toTaiKhoanResponse(TaiKhoan entity);

    void updateTaiKhoan(@MappingTarget TaiKhoan taiKhoan, TaiKhoanRequest request);
}
