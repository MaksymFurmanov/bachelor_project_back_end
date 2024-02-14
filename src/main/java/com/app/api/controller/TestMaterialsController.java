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
    public ResponseEntity<List<TestMaterials>> getTestsMaterials() {
        List<TestMaterials> testsMaterials = testMaterialsService.getTestsMaterials();
        if(testsMaterials != null) return ResponseEntity.ok(testsMaterials);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Void> newTestMaterials(@RequestBody() TestMaterials testMaterials) {
        if(testMaterials != null)testMaterialsService.newTestMaterials(testMaterials);
        else return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(null);
    }

    @PostMapping("/load-tests-materials")
    public ResponseEntity<Void> loadTestsMaterials(@RequestBody() TestMaterials[] testsMaterials) {
        testMaterialsService.loadTestsMaterials(testsMaterials);
        return ResponseEntity.ok(null);
    }
}
