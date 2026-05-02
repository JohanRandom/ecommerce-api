package com.johan.ecommerce.dto;

import lombok.*;

/**
 * Vista resumida de producto para respuestas donde no se requiere todo el modelo.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
}
