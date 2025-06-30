# 🛠️ Prueba Técnica SYSMAN - API de Gestión de Materiales

Este proyecto es una API RESTful construida con **Spring Boot 3.5+** y **Java 17**, que permite gestionar materiales asociados a ciudades y departamentos de Colombia, usando códigos oficiales. Incluye autenticación JWT, validaciones, documentación Swagger, manejo global de excepciones y datos de prueba (seeds) para facilitar las pruebas manuales.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5+
- Spring Security + JWT
- Spring Data JPA
- Base de datos PostgreSQL
- MapStruct
- Lombok
- Swagger / OpenAPI 3
- Git y Git Flow

---

## ✅ Funcionalidades implementadas

- CRUD completo para materiales.
- Filtros combinables por tipo, ciudad y fecha de compra.
- Validaciones de negocio (fechas, ciudad existente, etc.).
- Autenticación basada en JWT (roles: ADMIN y USER).
- Documentación Swagger.
- Seeds de datos para usuarios, roles, departamentos, ciudades y materiales.
- Manejo global de excepciones con mensajes personalizados.
- Configuración de CORS para facilitar integración frontend.

---

## 🔐 Credenciales de acceso

Se crean automáticamente al iniciar la aplicación:

| Rol   | Email              | Contraseña |
|-------|--------------------|------------|
| ADMIN | admin@example.com  | Pa55wordX  |
| USER  | juan@example.com   | Xyz123AB   |
| USER  | ana@example.com    | aBcD9876   |

---

## ▶️ Cómo ejecutar el proyecto

### 🔧 Requisitos previos

- Java 17+
- Maven 3.8+
- IDE compatible (IntelliJ, Eclipse, VSCode)

### 🚦 Instrucciones

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/prueba-tecnica-sysman-backend.git
   cd prueba-tecnica-sysman-backend
   ```

2. Ejecuta el proyecto:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Accede a la documentación Swagger en:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## 🧪 Endpoints principales

> Todos los endpoints están documentados en Swagger.

- `POST /api/v1/auth/register`: Registro de nuevo usuario
- `POST /api/v1/auth/login`: Autenticación y obtención de token JWT
- `GET /api/v1/materials`: Lista o filtra materiales (**ADMIN**, **USER**)
- `GET /api/v1/materials/{id}`: Consulta material por ID (**ADMIN**, **USER**)
- `POST /api/v1/materials`: Crea un nuevo material (**ADMIN**)
- `PUT /api/v1/materials/{id}`: Actualiza un material (**ADMIN**)
- `DELETE /api/v1/materials/{id}`: Elimina un material (**ADMIN**)

---

## 🛡️ Seguridad

- Cualquier usuario autenticado puede consultar materiales.
- Solo los usuarios con rol `ADMIN` pueden crear, actualizar o eliminar.
- El token JWT debe incluirse en el encabezado `Authorization` como `Bearer <token>`.

---

## 🧷 Consideraciones técnicas

- Se usa `MapStruct` para mapear entre entidades y DTOs.
- Se implementa manejo global de errores con `@RestControllerAdvice`.
- Se validan fechas y existencia de ciudad antes de crear/actualizar.
- La base de datos se alimenta con seeds una unica vez al iniciar la aplicación.

---

## 📬 Contacto

Ovidio Romero  
Desarrollador FullStack - Especialista en Desarrollo de Software

📧 ovidioromero66@gmail.com  
🔗 [LinkedIn](https://linkedin.com/in/ovidio-romero/)
🔗 [GitHub](https://github.com/ROGUEANOVI)
---