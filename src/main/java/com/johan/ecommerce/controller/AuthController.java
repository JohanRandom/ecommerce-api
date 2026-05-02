package com.johan.ecommerce.controller;

import com.johan.ecommerce.entity.User;
import com.johan.ecommerce.service.AuthService;
import com.johan.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Expone los endpoints publicos para registro de usuarios e inicio de sesion.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;
    private final UserService userService;

    public AuthController(AuthService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    /**
     * Valida email y contrasena; si son correctos devuelve un token JWT.
     */
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {

        String token = service.login(body.get("email"), body.get("password"));

        return Map.of("token", token);
    }

    /**
     * Crea un usuario nuevo reutilizando el flujo que encripta la contrasena.
     */
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }
}
