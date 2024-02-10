package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "production_processes")
public class ProductionProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long production_process_id;

    Long product_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    Product product;

    Long department_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", insertable = false, updatable = false)
    Department department;

    String name;

    int queue;

    String done_name;

    public ProductionProcess(Long production_process_id, Long product_id, Long department_id, String name, int queue, String done_name) {
        this.production_process_id = production_process_id;
        this.product_id = product_id;
        this.department_id = department_id;
        this.name = name;
        this.queue = queue;
        this.done_name = done_name;
    }

    public ProductionProcess() {}

    public Long getProduction_process_id() {
        return production_process_id;
    }

    public void setProduction_process_id(Long production_process_id) {
        this.production_process_id = production_process_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public String getDone_name() {
        return done_name;
    }

    public void setDone_name(String done_name) {
        this.done_name = done_name;
    }

    @Override
    public String toString() {
        return "ProductionProcess{" +
                "production_process_id=" + production_process_id +
                ", product_id=" + product_id +
                ", department_id=" + department_id +
                ", name='" + name + '\'' +
                ", queue=" + queue +
                ", done_name='" + done_name + '\'' +
                '}';
    }
}
