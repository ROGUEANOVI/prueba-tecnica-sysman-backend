package com.sysman.prueba_tecnica_sysman_backend.exception;

public class DuplicateMaterialException extends RuntimeException {

    public DuplicateMaterialException(String message, String materialName, String materialType, String cityCode) {
        super(String.format(message, materialName, materialType, cityCode));
    }
}
