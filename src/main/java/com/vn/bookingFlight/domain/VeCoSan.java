package com.vn.bookingFlight.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ve_co_san")
public class VeCoSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mave;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "maCB", referencedColumnName = "maCB"),
            @JoinColumn(name = "ngayKhoiHanh", referencedColumnName = "ngayKhoiHanh")
    })
    private ChuyenBay chuyenBay;

    @ManyToOne
    @JoinColumn(name = "maHangGhe")
    private HangGhe hangGhe;

    private String soGhe;

    @ManyToOne
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "maDatVe")
    private DatVe datVe;
}
