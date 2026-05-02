package com.johan.ecommerce.controller;

import com.johan.ecommerce.entity.User;
import com.johan.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * Expone operaciones basicas de usuarios.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Crea un usuario guardando la contrasena encriptada.
     */
    @PostMapping
    public User create(@RequestBody User user) {
        return service.save(user);
    }
}
