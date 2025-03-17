package com.vn.bookingFlight.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "availableticket")
public class AvailableTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "seatId")
    private SeatClass seatClass;

    private String seatNum;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "bookingFlightId", nullable = true)
    private BookingFlight bookingFlight;
}
