package com.javagirls.MangoRoom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.enumeration.PaymentCurrency;
import com.javagirls.MangoRoom.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkIn;

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    @OneToOne
    public Room room;
}
