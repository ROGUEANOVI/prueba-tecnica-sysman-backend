package com.sysman.prueba_tecnica_sysman_backend.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message, String email) {
        super(String.format(message, email));
    }
}
