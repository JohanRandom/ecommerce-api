package com.johan.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
     * Se guarda encriptada y se oculta en respuestas JSON.
     */
    @JsonIgnore
    private String password;

    /**
     * Ordenes del usuario; se ocultan para evitar respuestas grandes o ciclos JSON.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
