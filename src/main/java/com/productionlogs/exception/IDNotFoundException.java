package com.productionlogs.exception;

public class IDNotFoundException extends RuntimeException {
    public static final String ID_NOT_FOUND = "ID not found!";

    public IDNotFoundException() {
    }

    public IDNotFoundException(String message) {
        super(message);
    }

    public IDNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IDNotFoundException(Throwable cause) {
        super(cause);
    }

    public IDNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return ID_NOT_FOUND;
    }
}
