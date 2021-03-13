package com.javagirls.MangoRoom.validation;

import com.javagirls.MangoRoom.dto.ReservationDto;
import com.javagirls.MangoRoom.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class ReservationValidator implements Validator {

	private final RoomService roomService;

	public ReservationValidator(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return ReservationDto.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ReservationDto reservationDto = (ReservationDto) target;
		log.debug("Validating {}", target);

		if (!checkRoomAvailability(reservationDto.getRoomId())) {
			errors.reject(String.format("Room %d is already booked!", reservationDto.getRoomId()));
		}
	}

	private boolean checkRoomAvailability(int roomId) {
		return roomService.findById(roomId).isAvailableForBooking();
	}

}
