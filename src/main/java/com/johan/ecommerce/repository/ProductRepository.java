package com.johan.ecommerce.repository;

import com.johan.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de productos y consulta para validar nombres repetidos.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
}
