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

    public void newTestMaterials (TestMaterials testMaterials) {
        testMaterialsRepository.save(testMaterials);
    }

    public void loadTestsMaterials(TestMaterials[] testsMaterials) {
        testMaterialsRepository.saveAll(Arrays.asList(testsMaterials));
    }
}
