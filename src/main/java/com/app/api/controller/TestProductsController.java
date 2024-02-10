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
    private final TestProductsService testMaterialsService;

    @Autowired
    public TestProductsController(TestProductsService testMaterialsService) {
        this.testMaterialsService = testMaterialsService;
    }

    @GetMapping("/tests-materials/get-tests-materials")
    public ResponseEntity<List<TestProducts>> getTestaProducts() {
        List<TestProducts> testsMaterials = testMaterialsService.getTestsProducts();
        if(testsMaterials != null) return ResponseEntity.ok(testsMaterials);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tests-materials/load-tests-materials")
    public ResponseEntity<Void> loadTestsProducts(@RequestBody() TestProducts[] testsMaterials) {
        testMaterialsService.loadTestsProducts(testsMaterials);
        return ResponseEntity.ok(null);
    }
}
