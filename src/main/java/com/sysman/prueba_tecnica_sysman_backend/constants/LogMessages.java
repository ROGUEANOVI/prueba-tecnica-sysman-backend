package com.sysman.prueba_tecnica_sysman_backend.constants;

public class LogMessages {

    private LogMessages() {}

    public static final String CREATING_MATERIAL = "Creating material with type: {}";
    public static final String UPDATING_MATERIAL = "Updating material with id: {}";
    public static final String DELETING_MATERIAL = "Deleting material with id: {}";

    public static final String MATERIAL_NOT_FOUND = "Material not found: {}";
    public static final String INVALID_MATERIAL_DATES = "Invalid material dates: {}";
    public static final String UNEXPECTED_ERROR = "Unexpected error: {}";

    public static final String USER_NOT_FOUND = "User not found with email: {}";
    public static final String INVALID_TOKEN = "Invalid JWT token: {}";

    public static final String ROLE_NOT_FOUND = "Role not found: {}";
    public static final String USER_ALREADY_EXISTS = "User already exists: {}";
}
