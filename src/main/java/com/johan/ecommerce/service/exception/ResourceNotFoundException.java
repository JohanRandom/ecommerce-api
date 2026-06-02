package com.johan.ecommerce.service.exception;

/**
 * Excepcion de dominio para indicar que un recurso buscado no existe.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
