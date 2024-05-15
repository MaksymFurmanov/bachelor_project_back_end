package com.app.api.controller;

import com.app.api.model.Order;
import com.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        if (orders != null) return ResponseEntity.ok(orders);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/done")
    public ResponseEntity<Order> processDone(@RequestBody() Long orderId) {
        if (orderId == null) ResponseEntity.badRequest().build();
        return ResponseEntity.ok(orderService.processDone(orderId));
    }

    @PostMapping("/new")
    public ResponseEntity<Order> newOrder(@RequestBody() Order order) {
        if (order == null) return ResponseEntity.badRequest().build();
        Order newOrder = orderService.newOrder(order);
        if (newOrder != null) return ResponseEntity.ok(newOrder);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        if (order == null) return ResponseEntity.badRequest().build();
        Order updatedOrder = orderService.updateOrder(order);
        if (updatedOrder != null) return ResponseEntity.ok(updatedOrder);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteOrder(@RequestBody() Long orderId) {
        if (orderId == null) return ResponseEntity.badRequest().build();
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok(null);
    }
}
