package com.app.api.controller;

import com.app.api.model.Department;
import com.app.api.model.Employee;
import com.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        if (departments != null) return ResponseEntity.ok(departments);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/set-manager")
    public ResponseEntity<Department> setManager(@RequestBody() Employee employee) {
        if (employee == null) return ResponseEntity.notFound().build();
        Department updatedDepartment = departmentService.setManager(employee);
        if (updatedDepartment != null) return ResponseEntity.ok(updatedDepartment);
        else return ResponseEntity.badRequest().build();
    }
}
