package com.app.api.controller;

import com.app.api.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/user/log-in")
    public ResponseEntity<Employee> logInUser(@RequestParam String username,
                                              @RequestParam String password) {
        if (username == null || password == null)
            return ResponseEntity.badRequest().build();
        Employee result = employeeService.logIn(username, password);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        if (employees != null) return ResponseEntity.ok(employees);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/employees/new")
    public ResponseEntity<Employee> newEmployee(@RequestBody() Employee employee) {
        if (employee == null) return ResponseEntity.badRequest().build();
        Employee newEmployee = employeeService.newEmployee(employee);
        if (newEmployee != null) return ResponseEntity.ok(newEmployee);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/employees/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        if (employee == null) return ResponseEntity.badRequest().build();
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        if (updatedEmployee != null) return ResponseEntity.ok(updatedEmployee);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/employees/delete")
    public ResponseEntity<Void> deleteEmployee(@RequestBody() Long employeeId) {
        if (employeeId == null) return ResponseEntity.badRequest().build();
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(null);
    }
}
