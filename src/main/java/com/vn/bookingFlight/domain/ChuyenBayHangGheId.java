package com.vn.bookingFlight.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChuyenBayHangGheId implements Serializable {
    private Integer maCB;
    private Date ngayKhoiHanh;
    private String maGhe;
}