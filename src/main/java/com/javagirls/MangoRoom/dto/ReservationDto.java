package com.javagirls.MangoRoom.dto;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ReservationDto {

    @NotBlank
    private LocalDateTime checkIn;

    @NotBlank
    private LocalDateTime checkOut;

    @NotBlank
    private Integer numberOfPeople;

    @NotBlank
    private PaymentCurrency paymentCurrency;

    @NotBlank
    private Boolean businessTrip;

    @NotBlank
    private Boolean paid;

    private Status status;
}
