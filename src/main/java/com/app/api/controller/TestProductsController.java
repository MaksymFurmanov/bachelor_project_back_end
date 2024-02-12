package com.app.api.controller;

import com.app.api.model.TestProducts;
import com.app.service.TestProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestProductsController {
    private final TestProductsService testProductsService;

    @Autowired
    public TestProductsController(TestProductsService testProductsService) {
        this.testProductsService = testProductsService;
    }

    @GetMapping("/tests-products/get-tests-products")
    public ResponseEntity<List<TestProducts>> getTestaProducts() {
        List<TestProducts> testsProducts = testProductsService.getTestsProducts();
        if(testsProducts != null) return ResponseEntity.ok(testsProducts);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tests-products/load-tests-products")
    public ResponseEntity<Void> loadTestsProducts(@RequestBody() TestProducts[] testsProducts) {
        testProductsService.loadTestsProducts(testsProducts);
        return ResponseEntity.ok(null);
    }
}
