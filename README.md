# API de E-commerce

API REST desarrollada con **Spring Boot** para gestionar usuarios, productos y pedidos con autenticación segura mediante
**JWT**.

Table of Contents
-----------------

- [Demo en vivo](#demo-en-vivo)
- [Tecnologías utilizadas](#tecnolog%C3%ADas-utilizadas)
- [Autenticación](#autenticaci%C3%B3n)
- [Endpoints principales](#endpoints-principales)
- [Variables de entorno](#variables-de-entorno)
- [Ejecución local](#ejecuci%C3%B3n-local)
- [Base de datos (Docker)](#base-de-datos-docker)
- [Ejemplos de uso (curl)](#ejemplos-de-uso-curl)
- [Testing](#testing)
- [Autor](#autor)

---

## Demo en vivo

### API

https://ecommerce-api-ln7m.onrender.com

### Frontend

https://ecommerce-web-gamma-one.vercel.app/

### Repositorios

https://github.com/JohanRandom/ecommerce-web

### Verificación de estado

```json
{
  "message": "E-commerce API is running successfully",
  "status": "online"
}
```

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL (Supabase)
- Autenticación JWT
- BCrypt
- Docker
- Render

---

## Autenticación

La API usa autenticación JWT para proteger los endpoints privados.

### Endpoint de inicio de sesión

```http
POST /api/auth/login
```

### Cuerpo de la solicitud

```json
{
  "email": "test@ecommerce.com",
  "password": "test123"
}
```

### Ejemplo de respuesta

```json
{
  "token": "YOUR_JWT_TOKEN"
}
```

---

## Usuario de prueba

Puedes probar la API usando esta cuenta de demostración:

```json
{
  "email": "test@ecommerce.com",
  "password": "test123"
}
```

---

## Endpoints principales

### Usuarios

```http
POST /api/users
```

Crea un nuevo usuario.

---

### Autenticación

```http
POST /api/auth/login
```

Genera un token JWT.

---

### Productos

```http
GET /api/products
POST /api/products
```

Gestiona productos.

---

### Pedidos

```http
POST /api/orders
```

Crea un pedido (requiere token JWT).

---

## Uso del token JWT

Incluye el token en los encabezados de la solicitud:

```http
Authorization: Bearer YOUR_JWT_TOKEN
```

---

## Variables de entorno

La aplicación usa variables de entorno para las credenciales de la base de datos.

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

---

## Funcionalidades

- Operaciones CRUD
- Autenticación JWT
- Cifrado de contraseñas con BCrypt
- Integración con base de datos PostgreSQL
- Relaciones entre entidades
- Validación de stock
- Arquitectura de API RESTful
- Despliegue en la nube con Render

---

## Ejecución local

Requisitos mínimos:

- JDK 17
- Maven (puedes usar el wrapper incluido)

Ejecutar con el Maven Wrapper (Windows):

```bash
mvnw.cmd spring-boot:run
```

O en sistemas Unix/macOS:

```bash
./mvnw spring-boot:run
```

Construir el artefacto y ejecutar el JAR:

```bash
./mvnw package
java -jar target/ecommerce-0.0.1-SNAPSHOT.jar
```

Si necesitas ejecutar un test concreto:

```bash
mvn -Dtest=AuthServiceTest test
```

---

## Base de datos (Docker)

Para facilitar el desarrollo local puedes levantar una instancia de PostgreSQL usando Docker Compose. Crea/usa el archivo `docker-compose.yml` en la raíz del proyecto y ejecuta:

```bash
docker compose up -d
```

La configuración por defecto del servicio expone PostgreSQL en el puerto 5432 y crea una base de datos `ecommerce`.

Ejemplo rápido para `spring.datasource.url`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=postgres
```

---

## Ejemplos de uso (curl)

Login / obtener token:

```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"test@ecommerce.com","password":"test123"}'
```

Crear usuario:

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"email":"new@example.com","password":"secret","name":"Nombre"}'
```

Obtener productos públicos:

```bash
curl http://localhost:8080/api/products
```

Crear pedido (requiere token JWT):

```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{"items":[{"productId":1,"quantity":2}]}'
```


## Testing

El proyecto incluye pruebas unitarias desarrolladas con JUnit 5 y Mockito.

Cobertura actual:

- Autenticación JWT
- Gestión de productos
- Validación de productos duplicados
- Validación de stock en órdenes

Ejecutar pruebas:

```bash
mvn test
```

---

## Autor

**Johan Moreno. Desarrollador de Software**
