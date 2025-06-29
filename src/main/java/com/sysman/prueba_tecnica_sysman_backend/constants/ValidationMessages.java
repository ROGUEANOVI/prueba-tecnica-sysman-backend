package com.sysman.prueba_tecnica_sysman_backend.constants;

public class ValidationMessages {

    private ValidationMessages() {}

    public static final String FIELD_REQUIRED = "This field is required.";
    public static final String NAME_TOO_LONG = "Name must be at most {max} characters.";
    public static final String DESCRIPTION_TOO_LONG = "Description must be at most {max} characters.";
    public static final String TYPE_TOO_LONG = "Type must be at most {max} characters.";
    public static final String STATUS_TOO_LONG = "Status must be at most {max} characters.";
    public static final String PRICE_MINIMUM = "Price must be greater than or equal to {value}.";
    public static final String INVALID_DATE = "Invalid date format.";
}
