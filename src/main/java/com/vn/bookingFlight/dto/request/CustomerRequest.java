package com.vn.bookingFlight.dto.request;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerRequest {
    private String hoTen;
    private Date ngaySinh;
    private String cccd;
    private String sdt;
    private String email;
}
