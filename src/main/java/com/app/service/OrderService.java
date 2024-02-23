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
import java.util.List;
import java.util.Optional;

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
        return orderRepository.save(order);
    }

    public void processDone(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        orderOptional.ifPresentOrElse(order -> {
            Product product = order.getProduct();
            Optional<ProductionProcess> productionProcessOptional =
                    Optional.ofNullable(order.getProductionProcess());

            productionProcessOptional.ifPresentOrElse(productionProcess -> {
                Optional<ProductionProcess> nextProcessOptional =
                        Optional.ofNullable(productionProcessRepository
                                .findByProductAndQueue(product,
                                        productionProcess.getQueue() + 1));

                nextProcessOptional.ifPresentOrElse(nextProcess -> {
                    order.setProduction_process_id(nextProcess
                            .getProduction_process_id());
                    orderRepository.save(order);
                }, () -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    String formattedDate = formatter.format(LocalDate.now());
                    order.setDone_date(formattedDate);
                    orderRepository.save(order);
                });
            }, () -> {
                Optional<ProductionProcess> firstProductionProcessOptional =
                        Optional.ofNullable(productionProcessRepository
                                .findByProductAndQueue(product, 0));

                firstProductionProcessOptional.ifPresentOrElse(firstProductionProcess -> {
                    order.setProduction_process_id(
                            firstProductionProcess.getProduction_process_id());
                    orderRepository.save(order);
                }, () -> {
                    throw new IllegalArgumentException("Production processes aren't defined");
                });
            });
        }, () -> {
            throw new IllegalArgumentException("Order is not found");
        });
    }

    public void loadOrders(Order[] orders) {
        orderRepository.saveAll(Arrays.asList(orders));
    }
}
