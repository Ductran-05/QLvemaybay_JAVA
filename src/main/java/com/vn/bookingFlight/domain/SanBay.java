package com.vn.bookingFlight.domain;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sanbay")
public class SanBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSb;

    private String tenSB;
    private String quocGia;
    private String thanhPho;

    @OneToMany(mappedBy = "sanBay")
    private List<SbCb> sbCbList;
}
