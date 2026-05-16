# 🛒 API de E-commerce

API REST desarrollada con **Spring Boot** para gestionar usuarios, productos y pedidos con autenticación segura mediante **JWT**.

---

## 🚀 Demo en vivo

🌐 URL base de la API:  
https://ecommerce-api-ln7m.onrender.com

### Verificación de estado

```json
{
  "message": "E-commerce API is running successfully 🚀",
  "status": "online"
}
```

---

## 🧰 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL (Supabase)
- Autenticación JWT
- BCrypt
- Docker
- Render

---

## 🔐 Autenticación

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

## 👤 Usuario de prueba

Puedes probar la API usando esta cuenta de demostración:

```json
{
  "email": "test@ecommerce.com",
  "password": "test123"
}
```

---

## 📦 Endpoints principales

### 👤 Usuarios

```http
POST /api/users
```

Crea un nuevo usuario.

---

### 🔐 Autenticación

```http
POST /api/auth/login
```

Genera un token JWT.

---

### 🛍️ Productos

```http
GET /api/products
POST /api/products
```

Gestiona productos.

---

### 📦 Pedidos

```http
POST /api/orders
```

Crea un pedido (requiere token JWT).

---

## 🔑 Uso del token JWT

Incluye el token en los encabezados de la solicitud:

```http
Authorization: Bearer YOUR_JWT_TOKEN
```

---

## ⚙️ Variables de entorno

La aplicación usa variables de entorno para las credenciales de la base de datos.

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

---

## 🧠 Funcionalidades

- Operaciones CRUD
- Autenticación JWT
- Cifrado de contraseñas con BCrypt
- Integración con base de datos PostgreSQL
- Relaciones entre entidades
- Validación de stock
- Arquitectura de API RESTful
- Despliegue en la nube con Render

---

## 📌 Autor

**Johan Moreno**

🔗 GitHub:  
https://github.com/JohanRandom

🔗 LinkedIn:  
https://www.linkedin.com/in/janmoreno-dev/
