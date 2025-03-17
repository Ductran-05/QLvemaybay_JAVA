package com.vn.bookingFlight.dto.response;

import lombok.Data;

@Data
public class AccountResponse {
    private Long _id;
    private String username;
    private String email;
    private String phone;
    private String fullName;
    private String gender;
    private String role;
    private String dob;
    private String updatedAt;
    private String createdAt;
}