package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    protected void saveReservation() {

    }

}
