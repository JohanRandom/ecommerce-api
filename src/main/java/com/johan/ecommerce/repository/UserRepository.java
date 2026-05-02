package com.johan.ecommerce.repository;

import com.johan.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de usuarios usando las operaciones base de JpaRepository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
