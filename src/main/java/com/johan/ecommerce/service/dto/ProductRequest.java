package com.johan.ecommerce.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
