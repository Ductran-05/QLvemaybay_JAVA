package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChuyenBay_HangGhe")
public class ChuyenBayHangGhe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maCB")
    private ChuyenBay chuyenBay;

    @ManyToOne
    @JoinColumn(name = "maHangGhe")
    private HangGhe hangGhe;

    private Integer soLuong;
}
