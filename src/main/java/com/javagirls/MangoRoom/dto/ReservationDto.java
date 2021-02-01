package com.javagirls.MangoRoom.dto;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class ReservationDto {

    private String id;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private Integer numberOfPeople;

    private PaymentCurrency paymentCurrency;

    private Boolean businessTrip;

    private Boolean paid;
}