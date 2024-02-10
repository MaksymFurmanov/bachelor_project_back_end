package com.app.api.controller;

import com.app.api.model.Material;
import com.app.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialController {
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/materials/get-materials")
    public ResponseEntity<List<Material>> getMaterials() {
        List<Material> materials = materialService.getMaterials();
        if(materials != null) return ResponseEntity.ok(materials);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/materials/load-materials")
    public ResponseEntity<Void> loadMaterials(@RequestBody() Material[] materials) {
        materialService.loadMaterials(materials);
        return ResponseEntity.ok(null);
    }
}
