package com.app.service;

import com.app.api.model.TestMaterials;
import com.app.repository.TestMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestMaterialsService {
    private final TestMaterialsRepository testMaterialsRepository;

    @Autowired
    public TestMaterialsService(TestMaterialsRepository testMaterialsRepository) {
        this.testMaterialsRepository = testMaterialsRepository;
    }

    public List<TestMaterials> getTestsMaterials() {
        return testMaterialsRepository.findAll();
    }

    public TestMaterials newTestMaterials (TestMaterials testMaterials) {
        TestMaterials savedTestMaterials = testMaterialsRepository.save(testMaterials);
        return testMaterialsRepository.findById(savedTestMaterials.getTest_id()).orElse(null);
    }

    public TestMaterials updateTestMaterials(TestMaterials testMaterials) {
        testMaterialsRepository.findById(testMaterials.getTest_id())
                .orElseThrow(() -> new IllegalArgumentException("Test materials not exist with this id"));
        TestMaterials updatedTestMaterials = testMaterialsRepository.save(testMaterials);
        return testMaterialsRepository.findById(updatedTestMaterials.getTest_id()).orElse(null);
    }
}
