package com.javagirls.MangoRoom.mapper;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import org.junit.jupiter.api.Test;

import static com.javagirls.MangoRoom.mock.ReservationDtoMock.getBasicReservationDto;
import static com.javagirls.MangoRoom.mock.ReservationMock.getBasicReservation;

public class ReservationMapperTest {

    @Test
    public void shouldMapReservationToReservationDto(){

        ReservationMapper reservationMapper = new ReservationMapper();
        Reservation reservation = getBasicReservation();

        final ReservationDto reservationDto = reservationMapper.map(reservation, ReservationDto.class);

        assert(reservation.getCheckIn().equals(reservationDto.getCheckIn()));
        assert(reservation.getCheckOut().equals(reservationDto.getCheckOut()));
    }

    @Test
    public void shouldMapReservationDtoToReservation(){

        ReservationMapper reservationMapper = new ReservationMapper();
        ReservationDto reservationDto = getBasicReservationDto();

        final Reservation reservation = reservationMapper.map(reservationDto, Reservation.class);

        assert(reservationDto.getCheckIn().equals(reservation.getCheckIn()));
        assert(reservationDto.getCheckOut().equals(reservation.getCheckOut()));
    }
}
