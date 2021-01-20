package com.javagirls.MangoRoom.errors;

public class NoGuestFoundException extends RuntimeException {

    public NoGuestFoundException() {
        super("Guest not found!");
    }
}
