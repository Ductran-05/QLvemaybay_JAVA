package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MayBay")
public class MayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maMB;
    private String tenMB;
}