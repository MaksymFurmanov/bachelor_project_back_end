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

    @PostMapping("/done")
    public ResponseEntity<Void> processDone(@RequestBody() Long orderId) {
        if(orderId == null)ResponseEntity.badRequest().build();
        orderService.processDone(orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-orders")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> orders = orderService.getOrders();
        if(orders != null) return ResponseEntity.ok(orders);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Order> newOrder(@RequestBody() Order order) {
        if(order == null)return ResponseEntity.badRequest().build();
        Order newOrder = orderService.newOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    @PostMapping("/load-orders")
    public ResponseEntity<Void> loadOrders(@RequestBody() Order[] orders) {
        orderService.loadOrders(orders);
        return ResponseEntity.ok(null);
    }
}
