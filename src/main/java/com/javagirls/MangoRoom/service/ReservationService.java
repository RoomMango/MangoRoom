package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.mapper.ReservationMapper;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ReservationMapper mapper;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Reservation saveReservation(ReservationDto reservationDto) {
        Reservation reservation = mapper.map(reservationDto, Reservation.class);
        return reservationRepository.save(reservation);
    }
}
