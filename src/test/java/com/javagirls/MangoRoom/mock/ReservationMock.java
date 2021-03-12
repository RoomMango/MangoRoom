package com.javagirls.MangoRoom.mock;

import com.javagirls.MangoRoom.entity.Reservation;

import java.time.LocalDateTime;

public final class ReservationMock {

    public ReservationMock(){
    }

    public static Reservation getBasicReservation() {
        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setCheckIn(LocalDateTime.now());
        reservation.setCheckOut(LocalDateTime.now());
        reservation.setPaid(true);

        return reservation;
    }
}
