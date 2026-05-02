package com.johan.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Registra beans compartidos de seguridad usados por autenticacion y usuarios.
 */
@Configuration
public class SecurityBeans {

    /**
     * Encoder BCrypt para guardar y validar contrasenas sin exponer texto plano.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
