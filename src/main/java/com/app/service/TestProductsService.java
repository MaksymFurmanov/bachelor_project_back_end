package com.app.service;

import com.app.api.model.TestProducts;
import com.app.repository.TestProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestProductsService {
    private final TestProductsRepository testProductsRepository;

    @Autowired
    public TestProductsService(TestProductsRepository testProductsRepository) {
        this.testProductsRepository = testProductsRepository;
    }

    public List<TestProducts> getTestsProducts() {
        return testProductsRepository.findAll();
    }

    public TestProducts newTestProducts (TestProducts testProducts) {
        TestProducts savedTestProducts = testProductsRepository.save(testProducts);
        return testProductsRepository.findById(savedTestProducts.getTest_id()).orElse(null);
    }

    public TestProducts updateTestProducts(TestProducts testProducts) {
        testProductsRepository.findById(testProducts.getTest_id())
                .orElseThrow(() -> new IllegalArgumentException("Test products not exist with this id"));
        TestProducts updatedTestProducts = testProductsRepository.save(testProducts);
        return testProductsRepository.findById(updatedTestProducts.getTest_id()).orElse(null);
    }
}
