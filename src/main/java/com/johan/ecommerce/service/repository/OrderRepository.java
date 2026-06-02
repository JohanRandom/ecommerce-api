package com.johan.ecommerce.service.repository;

import com.johan.ecommerce.service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de ordenes usando las operaciones base de JpaRepository.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
