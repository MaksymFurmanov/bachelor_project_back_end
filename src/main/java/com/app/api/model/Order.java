package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_seq_gen", allocationSize = 1)
    Long order_id;

    Long product_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    Product product;

    Long production_process_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "production_process_id", referencedColumnName = "production_process_id",
            insertable = false, updatable = false)
    ProductionProcess productionProcess;

    String customer;

    int volume;

    String pallet_color;

    String deadline;

    String done_date;

    public Order(Long order_id, Long product_id, Long production_process_id, String customer,
                 int volume, String pallet_color, String deadline, String done_date) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.production_process_id = production_process_id;
        this.customer = customer;
        this.volume = volume;
        this.pallet_color = pallet_color;
        this.deadline = deadline;
        this.done_date = done_date;
    }

    public Order() {}

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getProduction_process_id() {
        return production_process_id;
    }

    public void setProduction_process_id(Long production_process_id) {
        this.production_process_id = production_process_id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getPallet_color() {
        return pallet_color;
    }

    public void setPallet_color(String pallet_color) {
        this.pallet_color = pallet_color;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDone_date() {
        return done_date;
    }

    public void setDone_date(String done_date) {
        this.done_date = done_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", production_process_id=" + production_process_id +
                ", customer='" + customer + '\'' +
                ", volume=" + volume +
                ", pallet_color='" + pallet_color + '\'' +
                ", deadline='" + deadline + '\'' +
                ", done_date='" + done_date + '\'' +
                '}';
    }
}
