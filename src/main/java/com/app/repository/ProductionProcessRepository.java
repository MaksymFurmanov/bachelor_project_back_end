package com.app.repository;

import com.app.api.model.Product;
import com.app.api.model.ProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionProcessRepository extends JpaRepository<ProductionProcess, Long> {
    ProductionProcess findByProductAndQueue(Product product_id, int queue);
    List<ProductionProcess> findAllByProduct(Product product_id);
}
