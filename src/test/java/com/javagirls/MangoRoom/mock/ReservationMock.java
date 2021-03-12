package com.javagirls.MangoRoom.mock;

import com.javagirls.MangoRoom.entity.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class ReservationMock {

    public ReservationMock(){
    }

    public static Reservation getBasicReservation() {
        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setCheckIn(LocalDateTime.now());
//                (LocalDateTime.of(2021, 3, 13, 15, 0));
        reservation.setCheckOut(LocalDateTime.now());
//                (LocalDateTime.of(2021, 3, 16, 12, 0));
        reservation.setPaid(true);

        return reservation;
    }
}
