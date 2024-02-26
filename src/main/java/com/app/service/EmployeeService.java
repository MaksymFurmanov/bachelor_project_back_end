package com.app.service;

import com.app.api.model.Employee;
import com.app.repository.DepartmentRepository;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository) {
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

    public Employee newEmployee (Employee employee) {
        return employeeRepository.save(employee);
    }

    public void loadEmployees(Employee[] employees) {
        employeeRepository.saveAll(Arrays.asList(employees));
    }
}
