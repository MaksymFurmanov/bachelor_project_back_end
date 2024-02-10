package com.app.api.controller;

import com.app.api.model.TestMaterials;
import com.app.service.TestMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestMaterialsController {
    private final TestMaterialsService testMaterialsService;

    @Autowired
    public TestMaterialsController(TestMaterialsService testMaterialsService) {
        this.testMaterialsService = testMaterialsService;
    }

    @GetMapping("/tests-materials/get-tests-materials")
    public ResponseEntity<List<TestMaterials>> getTestsMaterials() {
        List<TestMaterials> testsMaterials = testMaterialsService.getTestsMaterials();
        if(testsMaterials != null) return ResponseEntity.ok(testsMaterials);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/tests-materials/load-tests-materials")
    public ResponseEntity<Void> loadTestsMaterials(@RequestBody() TestMaterials[] testsMaterials) {
        testMaterialsService.loadTestsMaterials(testsMaterials);
        return ResponseEntity.ok(null);
    }
}
