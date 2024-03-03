package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq_gen")
    @SequenceGenerator(name = "department_seq_gen", sequenceName = "department_seq_gen", allocationSize = 1)
    Long department_id;

    Long manager_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    Employee manager;

    String name;

    public Department(Long department_id, Long manager_id, String name) {
        this.department_id = department_id;
        this.manager_id = manager_id;
        this.name = name;
    }

    public Department() {}

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", manager_id=" + manager_id +
                ", manager=" + manager +
                ", name='" + name + '\'' +
                '}';
    }
}
