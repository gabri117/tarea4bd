# Sistema de Gestión Académica – CRUD API

API REST desarrollada en **Spring Boot** y **PostgreSQL** para gestionar Profesores, Estudiantes y Cursos, siguiendo una arquitectura por capas profesional.

## Tecnologías
- Java 21, Spring Boot 3.5.4
- PostgreSQL
- Spring Data JPA, Lombok
- Postman (pruebas)

## Configuración rápida

1. Crea la base de datos `gestion_academica_db` y ejecuta los scripts de tablas.
2. Edita `src/main/resources/application.properties` con tu usuario y contraseña de PostgreSQL.
3. Ejecuta el proyecto desde tu IDE:
4. La API queda disponible en `http://localhost:8080`

## Endpoints principales

- **Profesores:** `/profesores`
- **Estudiantes:** `/estudiantes`
- **Cursos:** `/cursos`

Soportan las operaciones CRUD: POST, GET, PUT, DELETE.

## Ejemplo de POST (Estudiante)

```json
{
"carnet": "20240001",
"nombre": "Andrea",
"apellido": "Martínez",
"fechaNacimiento": "2002-05-18"
}

Autor: José Gabriel Morales Galindo | gabri117
