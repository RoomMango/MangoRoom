package com.javagirls.MangoRoom.exceptions;

public class GuestExistException extends RuntimeException {
    public GuestExistException() {
        super("Guest already exist!");
    }
}
