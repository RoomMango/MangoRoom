package com.javagirls.MangoRoom.validation;

import com.javagirls.MangoRoom.dto.RoomDto;
import com.javagirls.MangoRoom.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class RoomValidator implements Validator {

	private final RoomService roomService;

	public RoomValidator(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return RoomDto.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RoomDto roomDto = (RoomDto) target;
		log.debug("Validating {}", target);

		if (isEmpty(errors.getFieldValue("roomNumber")) || isEmpty(errors.getFieldValue("beds")) ||
				isEmpty(errors.getFieldValue("extraBedAvailable")) || isEmpty(errors.getFieldValue("price")) ||
				isEmpty(errors.getFieldValue("balcony")) || isEmpty(errors.getFieldValue("roomType"))) {
			errors.reject("Please complete all fields");
		}

		if (!isRoomNumberAvailable(roomDto.getRoomNumber())) {
			errors.reject(String.format("Room %d already exist!", roomDto.getRoomNumber()));
		}

	}

	private boolean isEmpty(Object value) {
		return value == null || value.toString().trim().equals("");
	}

	private boolean isRoomNumberAvailable(int roomNumber) {
		return roomService.findById(roomNumber) == null;
	}


}
