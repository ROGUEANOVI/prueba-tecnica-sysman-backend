package com.sysman.prueba_tecnica_sysman_backend.constants;

public class MaterialConstants {

    public static final String BASE_PATH = "/api/v1/materials";

    public static final String TAG = "materials";
    public static final String TAG_DESCRIPTION = "Controlador para gestión de materiales";

    public static final String SUMMARY_SEARCH = "Listar todos los materiales o buscar por filtros: tipo, ciudad, fecha de compra";
    public static final String SUMMARY_GET_BY_ID = "Obtener un material por ID";
    public static final String SUMMARY_CREATE = "Crear un nuevo material";
    public static final String SUMMARY_UPDATE = "Actualizar un material por ID";
    public static final String SUMMARY_DELETE = "Eliminar un material por ID";

    public static final String DESC_FOUND = "Materiales encontrados";
    public static final String DESC_FOUND_ONE = "Material encontrado";
    public static final String DESC_CREATED = "Material creado exitosamente";
    public static final String DESC_UPDATED = "Material actualizado exitosamente";
    public static final String DESC_DELETED = "Material eliminado exitosamente";

    public static final String UNAUTHORIZED_RESPONSE = "No autorizado - Token inválido o ausente";
    public static final String BAD_REQUEST_RESPONSE = "Solicitud inválida - Error de validación de datos";
    public static final String FORBIDDEN_RESPONSE = "Acceso denegado - No tienes permisos para realizar esta operación";

    // MaterialRequestDTO
    public static final String NAME_DESCRIPTION = "Nombre del material";
    public static final String NAME_EXAMPLE = "Cemento gris";

    public static final String DESCRIPTION_DESCRIPTION = "Descripción detallada del material";
    public static final String DESCRIPTION_EXAMPLE = "Saco de cemento gris de 50 kg";

    public static final String TYPE_DESCRIPTION = "Tipo de material";
    public static final String TYPE_EXAMPLE = "Construcción";

    public static final String STATUS_DESCRIPTION = "Estado del material (ej. NUEVO, USADO)";
    public static final String STATUS_EXAMPLE = "NUEVO";

    public static final String PRICE_DESCRIPTION = "Precio del material en pesos colombianos";
    public static final String PRICE_EXAMPLE = "45000";

    public static final String PURCHASE_DATE_DESCRIPTION = "Fecha de compra del material";
    public static final String PURCHASE_DATE_EXAMPLE = "2024-04-10";

    public static final String SALE_DATE_DESCRIPTION = "Fecha de venta del material";
    public static final String SALE_DATE_EXAMPLE = "2024-06-15";

    public static final String CITY_CODE_DESCRIPTION = "Código DANE de la ciudad donde se encuentra el material";
    public static final String CITY_CODE_EXAMPLE = "25001";

    // MaterialResponseDTO
    public static final String ID_DESCRIPTION = "Identificador único del material";
    public static final String ID_EXAMPLE = "1";

    private MaterialConstants() {}
}
