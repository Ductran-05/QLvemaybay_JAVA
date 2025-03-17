package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VeCoSan")
public class VeCoSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maVe;

    @ManyToOne
    @JoinColumn(name = "maCB")
    private ChuyenBay chuyenBay;

    @ManyToOne
    @JoinColumn(name = "maHangGhe")
    private HangGhe hangGhe;

    private String soGhe;

    @ManyToOne
    @JoinColumn(name = "maKhachHang", nullable = true)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "maDatVe", nullable = true)
    private DatVeMayBay datVeMayBay;
}
