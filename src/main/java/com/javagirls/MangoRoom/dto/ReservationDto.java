package com.javagirls.MangoRoom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long id;

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkIn;

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOut;

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
