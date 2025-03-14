package com.vn.bookingFlight.domain;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "datve")
public class DatVe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDVe;

    private double giaVeTong;

    @ManyToOne
    @JoinColumn(name = "maAccount")
    private Account account;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "datVe", cascade = CascadeType.ALL)
    private List<VeCoSan> veCoSanList;
}
