package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entery_stock_places")
public class EnteryStockPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entery_stock_place_seq_gen")
    @SequenceGenerator(name = "entery_stock_place_seq_gen", sequenceName = "entery_stock_place_seq_gen", allocationSize = 1)
    Long entery_stock_place_id;

    Long material_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id", referencedColumnName = "material_id", insertable = false, updatable = false)
    Material material;

    int box;

    int queue;

    public EnteryStockPlace(Long entery_stock_place_id, Long material_id, int box, int index) {
        this.entery_stock_place_id = entery_stock_place_id;
        this.material_id = material_id;
        this.box = box;
        this.queue = index;
    }

    public EnteryStockPlace() {}

    public Long getEntery_stock_place_id() {
        return entery_stock_place_id;
    }

    public void setEntery_stock_place_id(Long entery_stock_place_id) {
        this.entery_stock_place_id = entery_stock_place_id;
    }

    public Long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Long material_id) {
        this.material_id = material_id;
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
        return "EnteryStockPlace{" +
                "entery_stock_place_id=" + entery_stock_place_id +
                ", material_id=" + material_id +
                ", box=" + box +
                ", queue=" + queue +
                '}';
    }
}
