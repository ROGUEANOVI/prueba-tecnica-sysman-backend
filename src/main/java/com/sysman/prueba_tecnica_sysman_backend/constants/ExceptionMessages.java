package com.sysman.prueba_tecnica_sysman_backend.constants;

public class ExceptionMessages {

    public static  final  String MESSAGE = "message";
    public static final String MATERIAL_NOT_FOUND = "Material not found with id: %s";
    public static final String INVALID_DATES = "Purchase date must be before sale date";
    public static final String UNEXPECTED_ERROR = "An unexpected error occurred on the server.";
    public static final String USER_NOT_FOUND = "User not found with email:";
    public static final String EXPIRED_TOKEN = "JWT token has expired";
    public static final String INVALID_TOKEN = "JWT token is invalid";

    public static final String USER_ALREADY_EXISTS = "User already exists with email: %s";
    public static final String ROLE_NOT_FOUND = "Role not found with name: %s";

    private ExceptionMessages() {}
}
