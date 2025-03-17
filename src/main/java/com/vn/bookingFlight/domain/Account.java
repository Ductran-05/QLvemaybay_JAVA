package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

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
