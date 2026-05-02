# 🛒 E-commerce API

API REST desarrollada con **Spring Boot** que permite gestionar usuarios, productos y pedidos con autenticación segura mediante **JWT**.

---

## 🚀 Demo

👉 https://ecommerce-api-ln7m.onrender.com

---

## 🧰 Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL (Supabase)
* JWT (JSON Web Token)
* BCrypt
* Docker
* Render (deploy)

---

## 🔐 Autenticación

La API usa JWT para proteger endpoints.

### Login

POST `/api/auth/login`

```json
{
  "email": "usuario@email.com",
  "password": "123456"
}
```

---

## 📦 Endpoints principales

### 👤 Usuarios

* POST `/api/users` → Crear usuario

### 🔐 Autenticación

* POST `/api/auth/login` → Obtener token

### 🛍️ Productos

* POST `/api/products` → Crear producto

### 📦 Pedidos

* POST `/api/orders` → Crear pedido (requiere token)

---

## 🔑 Uso de token

Agregar en headers:

```http
Authorization: Bearer TU_TOKEN
```

---

## ⚙️ Configuración

Las credenciales se manejan mediante variables de entorno:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

---

## 🧠 Características

* CRUD completo
* Relaciones entre entidades
* Validación de stock
* Autenticación con JWT
* Contraseñas encriptadas con BCrypt
* API desplegada en la nube

---

## 📌 Autor

**Johan Moreno**
