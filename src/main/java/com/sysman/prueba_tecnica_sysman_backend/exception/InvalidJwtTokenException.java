package com.sysman.prueba_tecnica_sysman_backend.exception;

public class InvalidJwtTokenException extends RuntimeException {

    public InvalidJwtTokenException(String message) {
        super(message);
    }
}
