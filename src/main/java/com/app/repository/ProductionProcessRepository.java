package com.app.repository;

import com.app.api.model.Product;
import com.app.api.model.ProductionProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionProcessRepository extends JpaRepository<ProductionProcess, Long> {
    ProductionProcess findByQueue(int queue);
    ProductionProcess findByProductAndQueue(Product product_id, int queue);

}
