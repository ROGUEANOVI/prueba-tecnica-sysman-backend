package com.sysman.prueba_tecnica_sysman_backend.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String message, String role) {
        super(String.format(message, role));
    }
}
