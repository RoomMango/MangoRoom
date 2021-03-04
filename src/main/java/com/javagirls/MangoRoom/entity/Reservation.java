package com.javagirls.MangoRoom.entity;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDateTime checkIn;

    @Column
    private LocalDateTime checkOut;

    @Column
    private Integer numberOfPeople;

    @Enumerated(EnumType.ORDINAL)
    private PaymentCurrency paymentCurrency;

    @Column
    private Boolean businessTrip;

    @Column
    private Boolean paid;

    @OneToMany
    private List<Room> rooms;


}
