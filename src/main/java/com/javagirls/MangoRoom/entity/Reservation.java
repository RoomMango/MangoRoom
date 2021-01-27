package com.javagirls.MangoRoom.entity;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    @NotBlank
    private Integer numberOfPeople;
    @Enumerated(EnumType.ORDINAL)
    @NotBlank
    private PaymentCurrency paymentCurrency;
    @NotBlank
    private Boolean businessTrip;
    @NotBlank
    private Boolean paid;

    @OneToMany
    private List<Room> rooms;


}
