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

    @GetMapping("")
    public ResponseEntity<List<Material>> getMaterials() {
        List<Material> materials = materialService.getMaterials();
        if (materials != null) return ResponseEntity.ok(materials);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Material> newMaterial(@RequestBody() Material material) {
        if (material == null) return ResponseEntity.badRequest().build();
        Material newMaterial = materialService.newMaterial(material);
        if(newMaterial != null) return ResponseEntity.ok(newMaterial);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/load-materials")
    public ResponseEntity<List<Material>> loadMaterials(@RequestBody() Material[] materials) {
        if (materials != null) return ResponseEntity.ok(materialService.loadMaterials(materials));
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMaterial(@RequestBody() Long materialId) {
        if (materialId == null) return ResponseEntity.badRequest().build();
        materialService.deleteMaterial(materialId);
        return ResponseEntity.ok(null);
    }
}