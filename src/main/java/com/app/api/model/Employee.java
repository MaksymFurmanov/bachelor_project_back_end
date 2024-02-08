package com.app.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(nullable = false)
    int employee_id;
    int department_id;
    String name;
    String position;
    String date_of_birth;
    String login;
    String password;

    public Employee(int employee_id, int department_id, String name,
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

    public Employee() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
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
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
