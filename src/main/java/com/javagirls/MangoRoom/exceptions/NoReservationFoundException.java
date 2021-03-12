package com.javagirls.MangoRoom.exceptions;

public class NoReservationFoundException extends RuntimeException {

	public NoReservationFoundException(Long id) {
		super(String.format("No reservation with id %d found!", id));
	}
}
