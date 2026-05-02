package com.johan.ecommerce.service;

import com.johan.ecommerce.dto.*;
import com.johan.ecommerce.entity.*;
import com.johan.ecommerce.exception.ResourceNotFoundException;
import com.johan.ecommerce.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Construye ordenes, valida stock y descuenta inventario al confirmar la compra.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    /**
     * Crea una orden para el usuario autenticado y genera sus detalles.
     */
    public Order createOrder(CreateOrderRequest request, String email) {

        User user = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        List<OrderDetail> details = new ArrayList<>();
        double total = 0;

        for (ProductRequest p : request.getProducts()) {

            Product product = productRepository.findById(p.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

            // Evita vender mas unidades de las disponibles.
            if (product.getStock() < p.getQuantity()) {
                throw new RuntimeException("Stock insuficiente para " + product.getName());
            }

            product.setStock(product.getStock() - p.getQuantity());
            productRepository.save(product);

            double subtotal = product.getPrice() * p.getQuantity();
            total += subtotal;

            OrderDetail detail = OrderDetail.builder()
                    .product(product)
                    .quantity(p.getQuantity())
                    .price(product.getPrice())
                    .build();

            details.add(detail);
        }

        Order order = Order.builder()
                .user(user)
                .total(total)
                .details(details)
                .build();

        // Conecta cada detalle con la orden antes de guardar en cascada.
        details.forEach(d -> d.setOrder(order));

        return orderRepository.save(order);
    }
}
