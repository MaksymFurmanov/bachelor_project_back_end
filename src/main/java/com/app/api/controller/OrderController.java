package com.app.api.controller;

import com.app.api.model.Order;
import com.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/get-orders")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        if(orders != null) return ResponseEntity.ok(orders);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/orders/load-orders")
    public ResponseEntity<Void> loadOrders(@RequestBody() Order[] orders) {
        orderService.loadOrders(orders);
        return ResponseEntity.ok(null);
    }
}
