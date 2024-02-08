package com.app;

import com.app.api.model.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BpBackEndApplication implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public BpBackEndApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BpBackEndApplication.class, args);
    }

    @Override
    public void run(String... args) {
        employeeRepository.save(new Employee(
                0,
                2,
                "Maksym Furmanov",
                "Riaditeľ podniku",
                "17.03.2004",
                "admin",
                "admin"
        ));
    }
}
