package com.sysman.prueba_tecnica_sysman_backend.constants;

public class LocationConstants {

    public static final String PATH = "/api/v1/locations";

    public static final String TAG = "Ubicaciones";
    public static final String TAG_DESCRIPTION = "Controlador para gestión de ubicaciones";

    public static final String DEPARTMENTS_SUMMARY = "Listar todos los departamentos";
    public static final String DEPARTMENTS_DESC = "Obtiene una lista de todos los departamentos registrados en el sistema.";

    public static final String CITIES_SUMMARY = "Listar todas las ciudades o filtrar por código de departamento";
    public static final String CITIES_DESC = "Obtiene todas las ciudades o aquellas que pertenecen al departamento indicado por su código.";

    public static final String PARAM_DEPARTMENT_CODE = "Código del departamento para filtrar las ciudades (opcional)";

    public static final String DEPARTMENTS_RESPONSE_DESCRIPTION = "Departamentos obtenidos exitosamente";
    public static final String CITIES_RESPONSE_DESCRIPTION = "Ciudades obtenidas exitosamente";

    private LocationConstants() {}
}