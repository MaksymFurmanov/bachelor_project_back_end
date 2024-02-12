package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "output_stock_places")
public class OutputStockPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "output_stock_place_seq_gen")
    @SequenceGenerator(name = "output_stock_place_seq_gen", sequenceName = "output_stock_place_seq_gen", allocationSize = 1)
    Long output_stock_place_id;

    Long order_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    Order order;

    int box;

    int queue;

    public OutputStockPlace(Long output_stock_place_id, Long order_id, int box, int queue) {
        this.output_stock_place_id = output_stock_place_id;
        this.order_id = order_id;
        this.box = box;
        this.queue = queue;
    }

    public OutputStockPlace() {}

    public Long getOutput_stock_place_id() {
        return output_stock_place_id;
    }

    public void setOutput_stock_place_id(Long output_stock_place_id) {
        this.output_stock_place_id = output_stock_place_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "OutputStockPlace{" +
                "output_stock_place_id=" + output_stock_place_id +
                ", order_id=" + order_id +
                ", box=" + box +
                ", queue=" + queue +
                '}';
    }
}
