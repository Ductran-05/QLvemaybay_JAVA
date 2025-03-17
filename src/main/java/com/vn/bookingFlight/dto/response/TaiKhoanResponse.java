package com.vn.bookingFlight.dto.response;

import lombok.Data;

@Data
public class TaiKhoanResponse {
    private Long maTaiKhoan;
    private String username;
    private String email;
}