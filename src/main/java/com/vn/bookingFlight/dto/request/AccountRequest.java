package com.vn.bookingFlight.dto.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;
    private String gender;
    private String role;
    private String dob;
    private String updatedAt;
    private String createdAt;
}
