package com.johan.ecommerce.dto;

import lombok.*;
import java.util.List;

/**
 * Datos de entrada para crear una orden con uno o varios productos.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private List<ProductRequest> products;
}
