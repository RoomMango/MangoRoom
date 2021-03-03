package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.mapper.ReservationMapper;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ReservationMapper mapper;
    private RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    
    @Transactional
    public Reservation saveReservation(ReservationDto reservationDto) {
        Reservation reservation = mapper.map(reservationDto, Reservation.class);
        return reservationRepository.save(reservation);
    }

    @Transactional
    public List<ReservationDto> getRoomReservations(Room room) {
        return reservationRepository.findByRoom(room)
                .stream().map((reservation) -> mapper.map(reservation, ReservationDto.class))
                .collect(Collectors.toList());
    }

    private Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> {
            //fixme czy lepiej własne wyjątki?
            throw new NoSuchElementException("No reservation with provided id found!");
        });
    }

    public void changeReservationStatus(Long id, Status status) {
        findById(id).setStatus(status);
    }

}
