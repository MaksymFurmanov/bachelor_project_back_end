package com.app.service;

import com.app.api.model.Department;
import com.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public void newDepartment (Department department) {
        departmentRepository.save(department);
    }

    public void loadDepartments(Department[] departments) {
        departmentRepository.saveAll(Arrays.asList(departments));
    }
}
