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

    @GetMapping("/employees/get-employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        if(employees != null) return ResponseEntity.ok(employees);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> newEmployee(@RequestBody() Employee employee) {
        if(employee == null)return ResponseEntity.badRequest().build();
        Employee newEmployee = employeeService.newEmployee(employee);
        return ResponseEntity.ok(newEmployee);
    }

    @PostMapping("/employees/load-employees")
    public ResponseEntity<Void> loadEmployees(@RequestBody() Employee[] employees) {
        employeeService.loadEmployees(employees);
        return ResponseEntity.ok(null);
    }
}
