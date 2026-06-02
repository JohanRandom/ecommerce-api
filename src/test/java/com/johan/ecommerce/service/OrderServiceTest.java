package com.johan.ecommerce.service;

import com.johan.ecommerce.service.dto.CreateOrderRequest;
import com.johan.ecommerce.service.dto.ProductRequest;
import com.johan.ecommerce.service.entity.Product;
import com.johan.ecommerce.service.entity.User;
import com.johan.ecommerce.service.repository.OrderRepository;
import com.johan.ecommerce.service.repository.ProductRepository;
import com.johan.ecommerce.service.repository.UserRepository;
import com.johan.ecommerce.service.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldThrowExceptionWhenStockIsInsufficient() {

        User user = new User();
        user.setEmail("test@test.com");

        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        product.setStock(2);

        ProductRequest productRequest =
                new ProductRequest(1L, 5);

        CreateOrderRequest request =
                new CreateOrderRequest(
                        List.of(productRequest)
                );

        when(userRepository.findAll())
                .thenReturn(List.of(user));

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        RuntimeException exception =
                assertThrows(
                        RuntimeException.class,
                        () -> orderService.createOrder(
                                request,
                                "test@test.com"
                        )
                );

        assertTrue(
                exception.getMessage()
                        .contains("Stock insuficiente")
        );
    }
}