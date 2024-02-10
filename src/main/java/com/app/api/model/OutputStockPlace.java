package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "output_stock_places")
public class OutputStockPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long output_stock_place_id;

    Long order_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    Order order;

    int group;

    int index;

    public OutputStockPlace(Long output_stock_place_id, Long order_id, int group, int index) {
        this.output_stock_place_id = output_stock_place_id;
        this.order_id = order_id;
        this.group = group;
        this.index = index;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "OutputStockPlace{" +
                "output_stock_place_id=" + output_stock_place_id +
                ", order_id=" + order_id +
                ", group=" + group +
                ", index=" + index +
                '}';
    }
}
