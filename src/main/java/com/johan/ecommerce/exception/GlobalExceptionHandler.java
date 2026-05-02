package com.johan.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Convierte excepciones comunes en respuestas JSON consistentes para la API.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Responde 404 cuando un recurso solicitado no existe.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(ResourceNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return error;
    }

    /**
     * Responde 500 para errores no controlados sin exponer detalles internos.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGeneral(Exception ex) {
        ex.printStackTrace(); // Mantiene el detalle en consola para depuracion local.
        Map<String, String> error = new HashMap<>();
        error.put("error", "Error interno del servidor");
        return error;
    }
}
