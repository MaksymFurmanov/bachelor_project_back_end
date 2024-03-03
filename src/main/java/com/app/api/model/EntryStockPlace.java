package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ENTRY_STOCK_PLACES")
public class EntryStockPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_stock_place_seq_gen")
    @SequenceGenerator(name = "entry_stock_place_seq_gen", sequenceName = "entry_stock_place_seq_gen", allocationSize = 1)
    Long entry_stock_place_id;

    Long material_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id", referencedColumnName = "material_id", insertable = false, updatable = false)
    Material material;

    int box;

    int queue;

    public EntryStockPlace(Long entry_stock_place_id, Long material_id, int box, int index) {
        this.entry_stock_place_id = entry_stock_place_id;
        this.material_id = material_id;
        this.box = box;
        this.queue = index;
    }

    public EntryStockPlace() {}

    public Long getEntry_stock_place_id() {
        return entry_stock_place_id;
    }

    public void setEntry_stock_place_id(Long entry_stock_place_id) {
        this.entry_stock_place_id = entry_stock_place_id;
    }

    public Long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Long material_id) {
        this.material_id = material_id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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
        return "EntryStockPlace{" +
                "entry_stock_place_id=" + entry_stock_place_id +
                ", material_id=" + material_id +
                ", material=" + material +
                ", box=" + box +
                ", queue=" + queue +
                '}';
    }
}
