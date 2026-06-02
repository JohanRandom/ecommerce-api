package com.johan.ecommerce.service;

import com.johan.ecommerce.service.entity.Product;
import com.johan.ecommerce.service.repository.ProductRepository;
import com.johan.ecommerce.service.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldSaveProductSuccessfully() {

        Product product = new Product();
        product.setName("Laptop");

        when(repository.existsByName("Laptop"))
                .thenReturn(false);

        when(repository.save(product))
                .thenReturn(product);

        Product result = productService.save(product);

        assertEquals("Laptop", result.getName());

        verify(repository).save(product);
    }

    @Test
    void shouldThrowExceptionWhenProductAlreadyExists() {

        Product product = new Product();
        product.setName("Laptop");

        when(repository.existsByName("Laptop"))
                .thenReturn(true);

        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> productService.save(product)
                );

        assertEquals(
                "El producto ya existe",
                exception.getMessage()
        );
    }

}