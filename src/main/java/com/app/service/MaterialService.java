package com.app.service;

import com.app.api.model.Material;
import com.app.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> getMaterials() {
        return materialRepository.findAll();
    }

    public Material newMaterial(Material material) {
        Material savedMaterial = materialRepository.save(material);
        return materialRepository.findById(savedMaterial.getMaterial_id()).orElse(null);
    }

    public Material updateMaterial(Material material) {
        materialRepository.findById(material.getMaterial_id())
                .orElseThrow(() -> new IllegalArgumentException("Material not exist with this id"));
        Material updatedMaterial = materialRepository.save(material);
        return materialRepository.findById(updatedMaterial.getMaterial_id()).orElse(null);
    }

    public void deleteMaterial(Long materialId) {
        materialRepository.deleteAllById(Collections.singleton(materialId));
    }
}
