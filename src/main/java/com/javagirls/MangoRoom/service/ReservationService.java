package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.mapper.ReservationMapper;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ReservationMapper mapper;
    private RoomService roomService;


    public ReservationService(ReservationRepository reservationRepository, ReservationMapper mapper) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
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

    public List<ReservationDto> findAllWithTime(String time) {
        List<ReservationDto> result = new ArrayList<>();
        switch (time) {
            case "all":
                findAllReservationsDto().stream().map(reservationDto -> result.add(reservationDto))
                        .collect(Collectors.toList());
                break;
            case "future":
                findAllReservationsDto().stream()
                        .filter(reservationDto -> reservationDto.getCheckIn().truncatedTo(ChronoUnit.DAYS)
                                .isAfter(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)))
                        .map(reservationDto -> result.add(reservationDto)).collect(Collectors.toList());
                break;
            case "past":
                findAllReservationsDto().stream()
                        .filter(reservationDto -> reservationDto.getCheckIn().truncatedTo(ChronoUnit.DAYS)
                                .isBefore(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)))
                        .map(reservationDto -> result.add(reservationDto)).collect(Collectors.toList());
                break;
            case "now":
                findAllReservationsDto().stream()
                        .filter(reservationDto -> reservationDto.getCheckIn().truncatedTo(ChronoUnit.DAYS)
                                .equals(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)))
                        .map(reservationDto -> result.add(reservationDto)).collect(Collectors.toList());
                break;
            default:
                findAllReservationsDto().stream()
                        .filter(reservationDto -> (reservationDto.getCheckIn().truncatedTo(ChronoUnit.DAYS)
                                .equals(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS))
                                || (reservationDto.getCheckIn().truncatedTo(ChronoUnit.DAYS)
                                .isAfter(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)))))
                        .map(reservationDto -> result.add(reservationDto)).collect(Collectors.toList());
                break;
        }
        return result;
    }


    public List<ReservationDto> findAllReservationsDto() {
        return reservationRepository.findAll().stream()
                .map((reservation) -> mapper.map(reservation, ReservationDto.class)).collect(Collectors.toList());
    }


}
