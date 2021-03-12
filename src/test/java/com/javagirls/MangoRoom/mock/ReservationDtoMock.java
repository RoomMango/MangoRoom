package com.javagirls.MangoRoom.mock;

import com.javagirls.MangoRoom.dto.ReservationDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationDtoMock {

    public ReservationDtoMock(){

    }

    public static ReservationDto getBasicReservationDto() {

        ReservationDto reservationDto = new ReservationDto();

//        reservationDto.setId(1L);
        reservationDto.setCheckIn(LocalDateTime.now());
//                (LocalDateTime.of(2021, 3, 13, 15, 0));
        reservationDto.setCheckOut(LocalDateTime.now());
//                (LocalDateTime.of(2021, 3, 16, 12, 0));
        reservationDto.setPaid(true);

        return reservationDto;
    }
}
