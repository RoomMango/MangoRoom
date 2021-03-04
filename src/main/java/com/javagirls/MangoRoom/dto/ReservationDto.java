package com.javagirls.MangoRoom.dto;

import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class ReservationDto {

    private Long id;

    @NotBlank
    private LocalDate checkIn;

    private LocalDate checkOut;

    @Min(1)
    @Max(6)
    private Integer numberOfPeople;

    @NotBlank
    private PaymentCurrency paymentCurrency;

    @NotBlank
    private Boolean businessTrip;

    @NotBlank
    private Boolean paid;

    private Status status;

    @NotBlank
    private int roomId;
}
