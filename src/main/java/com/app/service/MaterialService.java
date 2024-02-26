package com.app.service;

import com.app.api.model.Material;
import com.app.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public Material newMaterial (Material material) {
        return materialRepository.save(material);
    }

    public void loadMaterials(Material[] materials) {
        materialRepository.saveAll(Arrays.asList(materials));
    }

    public void deleteMaterials(Long materialId) {
        materialRepository.deleteAllById(Collections.singleton(materialId));
    }
}
