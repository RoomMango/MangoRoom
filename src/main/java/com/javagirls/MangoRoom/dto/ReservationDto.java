package com.javagirls.MangoRoom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class ReservationDto {

    @NotBlank
    private Long id;

    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkIn;

    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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
