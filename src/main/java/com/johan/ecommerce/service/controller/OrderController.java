package com.johan.ecommerce.service.controller;

import com.johan.ecommerce.service.dto.CreateOrderRequest;
import com.johan.ecommerce.service.entity.Order;
import com.johan.ecommerce.service.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Recibe solicitudes de compra y las asocia al usuario autenticado por JWT.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    /**
     * Crea una orden usando el email agregado al request por JwtFilter.
     */
    @PostMapping
    public Order create(@RequestBody CreateOrderRequest request,
                        HttpServletRequest httpRequest) {

        String email = (String) httpRequest.getAttribute("userEmail");

        return service.createOrder(request, email);
    }
}
