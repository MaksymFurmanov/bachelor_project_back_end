package com.app.service;

import com.app.api.model.TestProducts;
import com.app.repository.TestProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
        return testProductsRepository.save(testProducts);
    }

    public void loadTestsProducts(TestProducts[] testsProducts) {
        testProductsRepository.saveAll(Arrays.asList(testsProducts));
    }
}
