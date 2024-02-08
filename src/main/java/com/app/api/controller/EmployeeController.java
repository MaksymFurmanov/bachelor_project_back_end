package com.app.api.controller;

import com.app.api.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/user/log_in")
    public ResponseEntity<Employee> logInUser(@RequestParam String username,
                                              @RequestParam String password) {
        if (username == null || password == null) return ResponseEntity.badRequest().build();
        Employee result = employeeService.logIn(username, password);
        if(result != null){
            return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
