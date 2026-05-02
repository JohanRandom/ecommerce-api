package com.johan.ecommerce.controller;

import com.johan.ecommerce.dto.ProductDTO;
import com.johan.ecommerce.entity.Product;
import com.johan.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * Administra el catalogo de productos y sus respuestas completas o resumidas.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * Registra un producto validando sus datos principales.
     */
    @PostMapping
    public Product create(@Valid @RequestBody Product product) {
        return service.save(product);
    }

    /**
     * Devuelve todos los productos con sus campos completos.
     */
    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    /**
     * Busca un producto por su identificador.
     */
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * Actualiza los datos editables de un producto existente.
     */
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    /**
     * Elimina un producto por su identificador.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    /**
     * Devuelve una vista liviana del catalogo sin stock ni descripcion.
     */
    @GetMapping("/dto")
    public List<ProductDTO> getAllDTO() {
        return service.getAllDTO();
    }
}
