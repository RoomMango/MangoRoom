package com.javagirls.MangoRoom.entity;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "reservation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private String id;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Integer numberOfPeople;
    private PaymentCurrency paymentCurrency;
    private Boolean businessTrip;
    private Boolean paid;

    @OneToMany
    private List<Room> rooms;
}
