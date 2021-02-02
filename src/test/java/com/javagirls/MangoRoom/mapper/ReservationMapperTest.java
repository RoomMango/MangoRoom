package com.javagirls.MangoRoom.mapper;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.javagirls.MangoRoom.ReservationMock.getBasicReservation;

public class ReservationMapperTest {

    @Test
    public void shouldMapReservationToReservationDto(){

        ReservationMapper reservationMapper = new ReservationMapper();
        Reservation reservation = getBasicReservation();

        final ReservationDto reservationDto = reservationMapper.map(reservation, ReservationDto.class);

        assert(reservation.getId().equals(reservationDto.getId()));
        assert(reservation.getCheckIn().equals(reservationDto.getCheckIn()));
        assert(reservation.getCheckOut().equals(reservationDto.getCheckOut()));
    }

    @Test
    public void shouldMapReservationDtoToReservation(){

        ReservationMapper reservationMapper = new ReservationMapper();

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(1L);
        reservationDto.setCheckIn(LocalDateTime.of(2021, 3, 13, 15, 0));
        reservationDto.setCheckOut(LocalDateTime.of(2021, 3, 16, 12, 0));
        reservationDto.setPaid(true);

        Reservation reservation = reservationMapper.map(reservationDto, Reservation.class);

        assert(reservationDto.getId().equals(reservation.getId()));
    }
}
