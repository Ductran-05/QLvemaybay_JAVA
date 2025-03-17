package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DatVeMayBay")
public class DatVeMayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maDatVe;
    private Double giaVeTong;

    @ManyToOne
    @JoinColumn(name = "maTaiKhoan")
    private TaiKhoan taiKhoan;
}
