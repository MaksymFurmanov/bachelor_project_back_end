package com.app.api.controller;

import com.app.api.model.TestProducts;
import com.app.service.TestProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests-products")
public class TestProductsController {
    private final TestProductsService testProductsService;

    @Autowired
    public TestProductsController(TestProductsService testProductsService) {
        this.testProductsService = testProductsService;
    }

    @GetMapping("/get-tests-products")
    public ResponseEntity<List<TestProducts>> getTestaProducts() {
        List<TestProducts> testsProducts = testProductsService.getTestsProducts();
        if (testsProducts != null) return ResponseEntity.ok(testsProducts);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<TestProducts> newTestProducts(@RequestBody() TestProducts testProducts) {
        if (testProducts == null) return ResponseEntity.badRequest().build();
        TestProducts newTestProducts = testProductsService.newTestProducts(testProducts);
        if(newTestProducts != null) return ResponseEntity.ok(newTestProducts);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/load-tests-products")
    public ResponseEntity<List<TestProducts>>
    loadTestsProducts(@RequestBody() TestProducts[] testsProducts) {
        if (testsProducts == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(testProductsService.loadTestsProducts(testsProducts));
    }
}
