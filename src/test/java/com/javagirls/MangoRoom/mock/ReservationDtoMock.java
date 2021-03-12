package com.javagirls.MangoRoom.mock;

import com.javagirls.MangoRoom.dto.ReservationDto;

import java.time.LocalDateTime;

public class ReservationDtoMock {

    public ReservationDtoMock(){

    }

    public static ReservationDto getBasicReservationDto() {

        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setCheckIn(LocalDateTime.now());
        reservationDto.setCheckOut(LocalDateTime.now());
        reservationDto.setPaid(true);

        return reservationDto;
    }
}
