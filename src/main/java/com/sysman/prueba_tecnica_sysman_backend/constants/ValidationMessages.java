package com.sysman.prueba_tecnica_sysman_backend.constants;

public class ValidationMessages {

    private ValidationMessages() {}

    public static final String FIELD_REQUIRED = "Este campo es obligatorio.";
    public static final String NAME_TOO_LONG = "El nombre debe tener como máximo {max} caracteres.";
    public static final String DESCRIPTION_TOO_LONG = "La descripción debe tener como máximo {max} caracteres.";
    public static final String TYPE_TOO_LONG = "El tipo debe tener como máximo {max} caracteres.";
    public static final String STATUS_TOO_LONG = "El estado debe tener como máximo {max} caracteres.";
    public static final String PRICE_MINIMUM = "El precio debe ser mayor o igual a {value}.";

}
