package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HangGhe")
public class HangGhe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maHangGhe;
    private String tenHangGhe;
    private Double giaThucTe;
}