package com.javagirls.MangoRoom.exceptions;

public class RoomNotFoundException extends RuntimeException {

	public RoomNotFoundException(){
		super("Room with provided number does not exist!");
	}

}
