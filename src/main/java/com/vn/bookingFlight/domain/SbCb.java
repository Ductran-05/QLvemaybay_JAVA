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
@Table(name = "SB_CB")
public class SBCB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maSB")
    private SanBay sanBay;

    @ManyToOne
    @JoinColumn(name = "maCB")
    private ChuyenBay chuyenBay;

    private Date tgDen;
    private Date tgDi;
}