package com.vn.bookingFlight.domain;

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
@Table(name = "maybay")
public class MayBay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maMB;

    @Column(length = 50, nullable = false)
    private String ten;

    @OneToMany(mappedBy = "mayBay", cascade = CascadeType.ALL)
    private List<ChuyenBay> chuyenBayList;
}
