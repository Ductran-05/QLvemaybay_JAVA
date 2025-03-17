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
@Table(name = "airport_flight")
public class AirPort_Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    @ManyToOne
    @JoinColumn(name = "airportId")
    private AirPort airPort;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    private Date arrivalDate;
    private Date departurDate;
}