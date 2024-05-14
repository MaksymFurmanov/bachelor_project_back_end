package com.app.service;

import com.app.api.model.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee logIn(String login, String password) {
        Employee employee = employeeRepository.findEmployeeByLogin(login);
        if (employee != null) {
            if (password.equals(employee.getPassword())) return employee;
        }
        return null;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee newEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeRepository.findById(savedEmployee.getEmployee_id()).orElse(null);
    }

    public List<Employee> loadEmployees(Employee[] employees) {
        return employeeRepository.saveAll(Arrays.asList(employees));
    }

    public Employee updateEmployee(Employee employee) {
        employeeRepository.findById(employee.getEmployee_id())
                .orElseThrow(() -> new IllegalArgumentException("Employee not exist with this id"));
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeRepository.findById(updatedEmployee.getEmployee_id()).orElse(null);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteAllById(Collections.singleton(employeeId));
    }
}
