package com.app.repository;

import com.app.api.model.TestProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestProductsRepository extends JpaRepository<TestProducts, Long> {
}
