package com.app.service;

import com.app.api.model.Order;
import com.app.api.model.Product;
import com.app.api.model.ProductionProcess;
import com.app.repository.OrderRepository;
import com.app.repository.ProductionProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductionProcessRepository productionProcessRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        ProductionProcessRepository productionProcessRepository) {
        this.orderRepository = orderRepository;
        this.productionProcessRepository = productionProcessRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order newOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return orderRepository.findById(savedOrder.getOrder_id()).orElse(null);
    }

    public Order processDone(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        Product product = order.getProduct();
        ProductionProcess productionProcess = order.getProductionProcess();

        if (productionProcess != null) {
            int nextQueue = productionProcess.getQueue() + 1;
            ProductionProcess nextProcess = productionProcessRepository
                    .findByProductAndQueue(product, nextQueue);
            if (nextProcess != null) {
                order.setProduction_process_id(nextProcess.getProduction_process_id());
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                String formattedDate = formatter.format(LocalDate.now());
                order.setDone_date(formattedDate);
            }
        } else {
            ProductionProcess firstProcess = productionProcessRepository
                    .findByProductAndQueue(product, 0);
            if (firstProcess != null) {
                order.setProduction_process_id(firstProcess.getProduction_process_id());
            } else {
                throw new IllegalArgumentException("Production processes aren't defined");
            }
        }

        Order savedOrder = orderRepository.save(order);
        return orderRepository.findById(savedOrder.getOrder_id()).orElse(null);
    }

    public List<Order> loadOrders(Order[] orders) {
        return orderRepository.saveAll(Arrays.asList(orders));
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteAllById(Collections.singleton(orderId));
    }
}
