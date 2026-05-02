package com.johan.ecommerce.dto;

import lombok.*;

/**
 * Producto y cantidad solicitados dentro de una orden.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Long productId;
    private Integer quantity;
}
