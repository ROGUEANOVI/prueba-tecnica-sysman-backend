package com.sysman.prueba_tecnica_sysman_backend.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String message, String cityCode) {
        super(String.format(message, cityCode));
    }
}
