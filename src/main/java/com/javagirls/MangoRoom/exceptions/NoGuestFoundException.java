package com.javagirls.MangoRoom.exceptions;

public class NoGuestFoundException extends RuntimeException {

    public NoGuestFoundException() {
        super("Guest not found!");
    }
}
