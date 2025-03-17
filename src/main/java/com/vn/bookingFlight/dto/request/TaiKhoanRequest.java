package com.vn.bookingFlight.dto.request;

import lombok.Data;

@Data
public class TaiKhoanRequest {
    private String username;
    private String password;
    private String email;
}
