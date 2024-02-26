package com.app.api.controller;

import com.app.api.model.Material;
import com.app.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialController {
    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/get-materials")
    public ResponseEntity<List<Material>> getMaterials() {
        List<Material> materials = materialService.getMaterials();
        if (materials != null) return ResponseEntity.ok(materials);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Material> newMaterial(@RequestBody() Material material) {
        if (material == null) return ResponseEntity.badRequest().build();
        Material newMaterial = materialService.newMaterial(material);
        return ResponseEntity.ok(newMaterial);
    }

    @PostMapping("/load-materials")
    public ResponseEntity<Void> loadMaterials(@RequestBody() Material[] materials) {
        if (materials != null) materialService.loadMaterials(materials);
        else return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMaterials(@RequestBody() Long materialId) {
        if (materialId == null) return ResponseEntity.badRequest().build();
        materialService.deleteMaterials(materialId);
        return ResponseEntity.ok(null);
    }
}