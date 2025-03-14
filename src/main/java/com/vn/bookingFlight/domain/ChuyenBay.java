package com.vn.bookingFlight.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "chuyenbay")
public class ChuyenBay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maCB;

    @ManyToOne
    @JoinColumn(name = "maMB")
    private MayBay mayBay;

    @ManyToOne
    @JoinColumn(name = "maSBdi")
    private SanBay sanBayDi;

    @ManyToOne
    @JoinColumn(name = "maSBden")
    private SanBay sanBayDen;

    @Column(nullable = false)
    private Date ngayKhoiHanh;

    private Time thoiGianDi;
    private Time thoiGianDen;

    private double giaVeGoc;

    @OneToMany(mappedBy = "chuyenBay", cascade = CascadeType.ALL)
    private List<SbCb> sbCbList;
}
