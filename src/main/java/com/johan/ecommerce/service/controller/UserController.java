package com.johan.ecommerce.service.controller;

import com.johan.ecommerce.service.entity.User;
import com.johan.ecommerce.service.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
