package com.app.service;

import com.app.api.model.Department;
import com.app.api.model.Employee;
import com.app.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Department setManager(Employee employee) {
        Optional<Department> departmentOptional =
                departmentRepository.findById(employee.getDepartment_id());
        System.out.println(employee);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setManager_id(employee.getEmployee_id());
            return departmentRepository.save(department);
        }
        return null;
    }
}
