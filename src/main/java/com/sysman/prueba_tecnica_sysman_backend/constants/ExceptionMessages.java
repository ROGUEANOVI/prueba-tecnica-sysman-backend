package com.sysman.prueba_tecnica_sysman_backend.constants;

public class ExceptionMessages {

    public static  final  String MESSAGE = "message";
    public static final String MATERIAL_NOT_FOUND = "Material con ID: %s no encontrado";
    public static final String INVALID_DATES = "La fecha de compra debe ser anterior a la fecha de venta";
    public static final String UNEXPECTED_ERROR = "Ocurrió un error inesperado en el servidor.";
    public static final String USER_NOT_FOUND = "Usuario no encontrado con el correo:";
    public static final String EXPIRED_TOKEN = "El token JWT ha expirado";
    public static final String INVALID_TOKEN = "El token JWT no es válido";
    public static final String USER_ALREADY_EXISTS = "Ya existe un usuario con el correo: %s";
    public static final String ROLE_NOT_FOUND = "Rol con el nombre: %s no encontrado";
    public static final String INVALID_DATE_FORMAT = "Formato de fecha inválido. Use yyyy-MM-dd";

    public static final String FORBIDDEN = "Acceso denegado";

    private ExceptionMessages() {}
}
