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

    @GetMapping("/get-departments")
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        if(departments != null) return ResponseEntity.ok(departments);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Department> newDepartment(@RequestBody() Department department) {
        if(department == null)return ResponseEntity.badRequest().build();
        Department newDepartment = departmentService.newDepartment(department);
        if(newDepartment != null) return ResponseEntity.ok(newDepartment);
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/set-manager")
    public ResponseEntity<Void> setManager(@RequestBody() Employee employee) {
        if (employee == null)return ResponseEntity.notFound().build();
        if(departmentService.setManager(employee))return null;
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/load-departments")
    public ResponseEntity<Void> loadDepartments(@RequestBody() Department[] departments) {
        departmentService.loadDepartments(departments);
        return ResponseEntity.ok(null);
    }
}
