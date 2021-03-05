package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.mapper.ReservationMapper;
import com.javagirls.MangoRoom.repository.ReservationRepository;
import com.javagirls.MangoRoom.repository.RoomRepository;
import org.springframework.stereotype.Repository;
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

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper mapper, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
        this.roomRepository = roomRepository;
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

    @Transactional
    public void deleteReservation(ReservationDto reservationDtoDelete) {

        Reservation delete = mapper.map(reservationDtoDelete, Reservation.class);
        reservationRepository.deleteById(delete.getId());

    }

    public void editReservation(Long id, ReservationDto reservationDtoChange) {

        Reservation editChange = mapper.map(reservationDtoChange, Reservation.class);

        Reservation repositoryOne = reservationRepository.getOne(id);
        repositoryOne.setBusinessTrip(editChange.getBusinessTrip());
        repositoryOne.setCheckIn(editChange.getCheckIn());
        repositoryOne.setCheckOut(editChange.getCheckOut());
        repositoryOne.setNumberOfPeople(editChange.getNumberOfPeople());
        repositoryOne.setPaid(editChange.getPaid());
        repositoryOne.setPaymentCurrency(editChange.getPaymentCurrency());
        repositoryOne.setRoom(editChange.getRoom());
        reservationRepository.save(editChange);

    }

    public List<Reservation> findAllReservation() {
        return reservationRepository.findAll();

    }
}