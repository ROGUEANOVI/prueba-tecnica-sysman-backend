package com.sysman.prueba_tecnica_sysman_backend.constants;

public class AuthConstants {
    public static final String BASE_PATH = "/api/v1/auth"; //AUTH_BASE_PATH
    // Tags
    public static final String TAG = "auth";
    public static final String TAG_DESCRIPTION = "Controlador para operaciones de autenticación y registro de usuarios.";

    // Endpoints summary
    public static final String REGISTER_SUMMARY = "Registro de nuevo usuario";
    public static final String LOGIN_SUMMARY = "Autenticación de usuario";
    public static final String ME_SUMMARY = "Obtener usuario autenticado actual";

    // Endpoints description
    public static final String REGISTER_DESCRIPTION = "Registra un nuevo usuario en el sistema. Requiere correo electrónico, nombre, contraseña y rol.";
    public static final String LOGIN_DESCRIPTION = "Autentica a un usuario existente con sus credenciales y devuelve un token JWT.";
    public static final String ME_DESCRIPTION = "Obtiene los detalles del usuario actualmente autenticado usando el token JWT.";

    // Response description
    public static final String UNAUTHORIZED_RESPONSE = "No autorizado - Token inválido o ausente";

    public static final String REGISTER_SUCCESS = "Usuario registrado exitosamente";
    public static final String BAD_REQUEST = "Solicitud inválida";
    public static final String LOGIN_SUCCESS = "Autenticación exitosa";
    public static final String BEARER_AUTH = "Bearer ";
    public static final String ME_SUCCESS = "Usuario autenticado exitosamente";
    public static final String FORBIDDEN = "Acceso denegado";

}
