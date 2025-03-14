package com.vn.bookingFlight.domain;

import java.time.LocalTime;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "sb_cb")
public class SbCb {
    @EmbeddedId
    private SbCbId id;

    @ManyToOne
    @MapsId("maCB")
    private ChuyenBay chuyenBay;

    @ManyToOne
    @MapsId("maSB")
    private SanBay sanBay;

    private LocalTime tgDen;
    private LocalTime tgDi;
}
