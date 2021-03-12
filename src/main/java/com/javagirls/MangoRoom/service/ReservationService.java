package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.exceptions.NoReservationFoundException;
import com.javagirls.MangoRoom.mapper.ReservationMapper;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import com.javagirls.MangoRoom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;
    private ReservationMapper mapper;

    @Transactional
    public Long saveReservation(ReservationDto reservationDto) {
        Room room = roomRepository.getOne(reservationDto.getRoomId());
        Reservation reservation = mapper.map(reservationDto, Reservation.class);
        reservation.setRoom(room);
        return reservationRepository.save(reservation).getId();
    }

    public List<ReservationDto> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map((reservation -> mapper.map(reservation, ReservationDto.class)))
                .collect(Collectors.toList());
    }

    public List<ReservationDto> getRoomReservations(Room room) {
        return reservationRepository.findByRoom(room)
                .stream().map((reservation) -> {
                    ReservationDto reservationDto = mapper.map(reservation, ReservationDto.class);
                    reservationDto.setRoomId(room.getRoomNumber());
                    return reservationDto;
                })
                .collect(Collectors.toList());
    }

    private Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> {
            throw new NoReservationFoundException(id);
        });
    }

    @Transactional
    public Status changeReservationStatus(Long id, Status status) {
        Reservation reservation = findById(id);
        reservation.setStatus(status);
        return reservationRepository.save(reservation).getStatus();
    }

}
