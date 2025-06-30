package com.sysman.prueba_tecnica_sysman_backend.constants;

public class SecurityConstants {

    public static final String BEARER_PREFIX = "Bearer ";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_PREFIX = "ROLE_";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String EMAIL_REQUIRED = "El email es requerido";
    public static final String EMAIL_INVALID = "El email es inválido";
    public static final String PASSWORD_REQUIRED = "La contraseña es requerida";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final String PASSWORD_PATTERN_MESSAGE = "La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una letra minúscula y un número";

    public static final String HAS_ROLE_ADMIN = "hasRole('ROLE_ADMIN')";
    public static final String HAS_ROLE_USER = "hasRole('ROLE_USER')";
    public static final String ROLE = "role";
}
