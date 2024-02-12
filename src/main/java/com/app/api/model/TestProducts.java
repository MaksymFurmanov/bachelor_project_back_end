package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tests_products")
public class TestProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_products_seq_gen")
    @SequenceGenerator(name = "test_products_seq_gen", sequenceName = "test_products_seq_gen", allocationSize = 1)
    Long test_id;

    Long order_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    Order order;

    int status;

    Boolean accepted;

    String document;

    public TestProducts(Long test_id, Long order_id, int status, Boolean accepted, String document) {
        this.test_id = test_id;
        this.order_id = order_id;
        this.status = status;
        this.accepted = accepted;
        this.document = document;
    }

    public TestProducts() {}

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "TestProducts{" +
                "test_id=" + test_id +
                ", order_id=" + order_id +
                ", status='" + status + '\'' +
                ", accepted=" + accepted +
                ", document='" + document + '\'' +
                '}';
    }
}
