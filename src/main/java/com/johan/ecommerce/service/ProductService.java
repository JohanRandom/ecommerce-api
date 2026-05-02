package com.johan.ecommerce.service;

import com.johan.ecommerce.dto.ProductDTO;
import com.johan.ecommerce.entity.Product;
import com.johan.ecommerce.exception.ResourceNotFoundException;
import com.johan.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Gestiona el catalogo de productos y sus validaciones principales.
 */
@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Guarda un producto nuevo evitando nombres duplicados.
     */
    public Product save(Product product) {
        if (repository.existsByName(product.getName())) {
            throw new RuntimeException("El producto ya existe");
        }
        return repository.save(product);
    }

    /**
     * Lista todos los productos registrados.
     */
    public List<Product> findAll() {
        return repository.findAll();
    }

    /**
     * Obtiene un producto o lanza 404 si no existe.
     */
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
    }

    /**
     * Actualiza solo los campos editables del producto.
     */
    public Product update(Long id, Product product) {
        Product existing = findById(id);

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());
        existing.setDescription(product.getDescription());

        return repository.save(existing);
    }

    /**
     * Elimina un producto por id.
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Proyecta productos a DTO para exponer solo id, nombre y precio.
     */
    public List<ProductDTO> getAllDTO() {
        return repository.findAll().stream()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice()))
                .toList();
    }
}
