package com.johan.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Compra realizada por un usuario, con total calculado y detalle de productos.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;

    /**
     * Usuario propietario de la orden.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Lineas de la orden; se guardan junto con la orden por CascadeType.ALL.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"order", "product"})
    private List<OrderDetail> details;
}
