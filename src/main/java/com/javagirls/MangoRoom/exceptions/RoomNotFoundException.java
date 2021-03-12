package com.javagirls.MangoRoom.exceptions;

public class RoomNotFoundException extends RuntimeException {

	public RoomNotFoundException(int id){
		super(String.format("Room with number %d does not exist!", id));
	}

}
