package com.javagirls.MangoRoom.service;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.entity.Reservation;
import com.javagirls.MangoRoom.entity.Room;
import com.javagirls.MangoRoom.enumeration.Status;
import com.javagirls.MangoRoom.exceptions.NoReservationFoundException;
import com.javagirls.MangoRoom.exceptions.RoomBookedException;
import com.javagirls.MangoRoom.exceptions.RoomNotFoundException;
import com.javagirls.MangoRoom.mapper.ReservationMapper;
import com.javagirls.MangoRoom.repository.ReservationRepository;

import com.javagirls.MangoRoom.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationService {

	private ReservationRepository reservationRepository;

	private RoomService roomService;

	private ReservationMapper mapper;

	@Transactional
	public Reservation saveReservation(ReservationDto reservationDto) {
		//FIXME zapętlenie
		int roomId = reservationDto.getRoomId();

		if (checkRoomAvailability(roomId)) {
			Room room = roomService.findById(roomId);
			Reservation reservation = mapper.map(reservationDto, Reservation.class);
			reservation.setRoom(room);
			return reservationRepository.save(reservation);
		} else {
			throw new RoomBookedException(roomId);
		}
	}

	private boolean checkRoomAvailability(int roomId) {
		return roomService.findById(roomId).isAvailableForBooking();
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
