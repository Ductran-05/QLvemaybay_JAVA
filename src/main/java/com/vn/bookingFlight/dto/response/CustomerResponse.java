package com.vn.bookingFlight.dto.response;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String hoTen;
    private Date ngaySinh;
    private String cccd;
    private String sdt;
    private String email;
}
