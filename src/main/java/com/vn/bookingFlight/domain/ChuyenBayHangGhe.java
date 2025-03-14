package com.vn.bookingFlight.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "chuyenbay_hangghe")
public class ChuyenBayHangGhe {
    @EmbeddedId
    private ChuyenBayHangGheId id;

    @ManyToOne
    @MapsId("maCB")
    private ChuyenBay chuyenBay;

    @ManyToOne
    @MapsId("maGhe")
    private HangGhe hangGhe;

    private int soLuong;
}
