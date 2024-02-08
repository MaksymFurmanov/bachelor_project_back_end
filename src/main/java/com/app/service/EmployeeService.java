package com.app.service;

import com.app.api.model.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
