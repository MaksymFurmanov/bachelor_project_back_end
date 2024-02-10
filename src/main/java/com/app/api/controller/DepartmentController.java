package com.app.api.controller;

import com.app.api.model.Department;
import com.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/get-departments")
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        if(departments != null) return ResponseEntity.ok(departments);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/departments/load-departments")
    public ResponseEntity<Void> loadDepartments(@RequestBody() Department[] departments) {
        departmentService.loadDepartments(departments);
        return ResponseEntity.ok(null);
    }
}
