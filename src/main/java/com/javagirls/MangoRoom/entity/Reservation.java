package com.javagirls.MangoRoom.entity;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
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

    @Column
    private Status status;

    @ManyToOne (fetch = FetchType.LAZY)
    private Room room;


}
