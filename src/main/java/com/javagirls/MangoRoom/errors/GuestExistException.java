package com.javagirls.MangoRoom.errors;

public class GuestExistException extends RuntimeException {
    public GuestExistException() {
        super("Guest already exist!");
    }
}
