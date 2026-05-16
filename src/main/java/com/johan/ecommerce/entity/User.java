package com.johan.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Usuario de la tienda. La contrasena y sus ordenes no se serializan en JSON.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    /**
     * Contraseña almacenada cifrada con BCrypt.
     * Este campo es de solo escritura para evitar su exposición en las respuestas de la API.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * Ordenes del usuario; se ocultan para evitar respuestas grandes o ciclos JSON.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
