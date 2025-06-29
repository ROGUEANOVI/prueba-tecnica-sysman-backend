package com.sysman.prueba_tecnica_sysman_backend.exception;

import java.text.Format;

public class MaterialNotFoundException extends RuntimeException {

    public MaterialNotFoundException(String message, Long id) {
        super(String.format(message, id));
    }
}
