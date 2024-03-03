package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "employee_seq_gen", allocationSize = 1)
    Long employee_id;
    Long department_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", insertable = false, updatable = false)
    Department department;

    String name;

    String position;

    String date_of_birth;

    String login;

    String password;

    public Employee(Long employee_id, Long department_id, String name,
                    String position, String date_of_birth,
                    String login, String password) {
        this.employee_id = employee_id;
        this.department_id = department_id;
        this.name = name;
        this.position = position;
        this.date_of_birth = date_of_birth;
        this.login = login;
        this.password = password;
    }

    public Employee() {}

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", department_id=" + department_id +
                ", department=" + department +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
