package com.johan.ecommerce.service.repository;

import com.johan.ecommerce.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de usuarios usando las operaciones base de JpaRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
