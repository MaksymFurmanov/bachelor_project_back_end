package com.app.repository;

import com.app.api.model.TestMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMaterialsRepository extends JpaRepository<TestMaterials, Integer> {
}
