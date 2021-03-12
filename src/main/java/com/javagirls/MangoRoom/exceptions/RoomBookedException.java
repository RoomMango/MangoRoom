package com.javagirls.MangoRoom.exceptions;

public class RoomBookedException extends RuntimeException {

	public RoomBookedException(int id){
		super(String.format("Room with number %d is already booked", id));
	}

}
