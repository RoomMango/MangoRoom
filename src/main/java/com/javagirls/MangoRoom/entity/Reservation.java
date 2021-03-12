package com.javagirls.MangoRoom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkIn;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;


}
