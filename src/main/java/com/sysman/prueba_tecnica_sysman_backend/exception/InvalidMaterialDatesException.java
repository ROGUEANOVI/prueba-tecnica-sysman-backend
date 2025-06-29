package com.sysman.prueba_tecnica_sysman_backend.exception;

public class InvalidMaterialDatesException extends RuntimeException {

    public InvalidMaterialDatesException(String message) {
        super(String.format(message));
    }
}
