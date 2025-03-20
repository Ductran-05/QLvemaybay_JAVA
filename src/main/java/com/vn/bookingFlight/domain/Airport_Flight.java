package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "airport_flight")
public class Airport_Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "airportId", nullable = false)
    private Airport airport;

    @ManyToOne
    @JoinColumn(name = "flightId", nullable = false)
    private Flight flight;

    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
}
