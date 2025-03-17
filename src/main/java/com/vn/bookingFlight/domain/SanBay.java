package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanBay")
public class SanBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maSB;
    private String tenSB;
    private String quocGia;
    private String thanhPho;
}