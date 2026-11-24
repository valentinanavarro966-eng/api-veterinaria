# API de Veterinaria

> **Proyecto académico.** Desarrollado como trabajo práctico de la materia Programación III de la Tecnicatura Universitaria en Programación (UTN – Facultad Regional Mar del Plata), 2026, para practicar relaciones entre entidades con JPA. La consigna fue planteada por la cátedra; el código es de mi autoría.

API REST desarrollada con **Java 21 y Spring Boot** para gestionar una veterinaria: clientes, sus mascotas, veterinarios y turnos.

## Tecnologías

- Java 21 · Spring Boot (Spring Web, Spring Data JPA)
- Hibernate · MySQL
- Lombok · Maven

## Modelo de datos

Cuatro entidades relacionadas con JPA:

- **Cliente** → tiene mascotas.
- **Mascota** → pertenece a un cliente.
- **Veterinario**.
- **Turno** → relaciona un cliente, una mascota y un veterinario (`@ManyToOne`), con fecha, hora, motivo y estado.

Para crear mascotas y turnos se usan **DTOs**, que reciben los ids de las entidades relacionadas.

## Endpoints

| Recurso | Endpoints |
|---|---|
| Clientes | `GET /clientes` · `GET /clientes/{id}` · `POST /clientes` · `PUT /clientes/{id}` |
| Mascotas | `GET /mascotas` · `GET /mascotas/{id}` · `POST /mascotas` · `PUT /mascotas/{id}` · `GET /mascotas/cliente/{idCliente}` |
| Veterinarios | `GET /veterinarios` · `GET /veterinarios/{id}` · `POST /veterinarios` · `PUT /veterinarios/{id}` |
| Turnos | `GET /turnos` · `GET /turnos/{id}` · `POST /turnos` · `PUT /turnos/{id}` · `DELETE /turnos/{id}` · `GET /turnos/veterinario/{idVeterinario}` |

## Cómo correrlo

1. Tener Java 21 y MySQL instalados, y crear la base de datos:
   ```sql
   CREATE DATABASE veterinaria;
   ```
2. Configurar la contraseña de MySQL como variable de entorno:
   ```bash
   export DB_PASSWORD=tu_contraseña      # Windows (PowerShell): $env:DB_PASSWORD="tu_contraseña"
   ```
   Opcionalmente también `DB_USER` (por defecto `root`) y `DB_URL`.
3. Levantar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
4. La API queda en `http://localhost:8080`.

## Autora

**Valentina Navarro** · [LinkedIn](https://linkedin.com/in/valentina-navarro-56561639a)
