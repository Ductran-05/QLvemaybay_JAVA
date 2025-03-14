package com.vn.bookingFlight.domain;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKH;

    private String hoTen;
    private LocalDate ngaySinh;

    @Column(length = 12, unique = true)
    private String cccd;

    @Column(length = 10, unique = true)
    private String sdt;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<VeCoSan> veCoSanList;
}
