package com.johan.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Linea de una orden: producto comprado, cantidad y precio usado en la compra.
 */
@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Double price;

    /**
     * Orden a la que pertenece esta linea.
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     * Producto vendido en esta linea de la orden.
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
