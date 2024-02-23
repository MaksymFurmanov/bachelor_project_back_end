package com.app.api.controller;

import com.app.api.model.TestMaterials;
import com.app.service.TestMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests-materials")
public class TestMaterialsController {
    private final TestMaterialsService testMaterialsService;

    @Autowired
    public TestMaterialsController(TestMaterialsService testMaterialsService) {
        this.testMaterialsService = testMaterialsService;
    }

    @GetMapping("/get-tests-materials")
    public ResponseEntity<List<TestMaterials>> getTestaMaterials() {
        List<TestMaterials> testsMaterials = testMaterialsService.getTestsMaterials();
        if(testsMaterials != null) return ResponseEntity.ok(testsMaterials);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<TestMaterials> newTestMaterials(@RequestBody() TestMaterials testMaterials) {
        if(testMaterials == null)return ResponseEntity.badRequest().build();
        TestMaterials newTestMaterials = testMaterialsService.newTestMaterials(testMaterials);
        return ResponseEntity.ok(newTestMaterials);
    }

    @PostMapping("/load-tests-materials")
    public ResponseEntity<Void> loadTestsMaterials(@RequestBody() TestMaterials[] testsMaterials) {
        testMaterialsService.loadTestsMaterials(testsMaterials);
        return ResponseEntity.ok(null);
    }
}
