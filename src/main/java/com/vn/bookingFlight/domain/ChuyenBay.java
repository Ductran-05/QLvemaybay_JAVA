package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChuyenBay")
public class ChuyenBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maCB;

    @ManyToOne
    @JoinColumn(name = "maMB")
    private MayBay mayBay;

    @ManyToOne
    @JoinColumn(name = "maSBdi")
    private SanBay sanBayDi;

    @ManyToOne
    @JoinColumn(name = "maSBden")
    private SanBay sanBayDen;

    private Date thoiGianDi;
    private Date thoiGianDen;
    private Double giaVeGoc;
}
