package com.app.service;

import com.app.api.model.TestMaterials;
import com.app.repository.TestMaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public List<TestMaterials> loadTestsMaterials(TestMaterials[] testsMaterials) {
        return testMaterialsRepository.saveAll(Arrays.asList(testsMaterials));
    }
}
