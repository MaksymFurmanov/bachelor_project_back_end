package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entery_stock_places")
public class EnteryStockPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long entery_stock_place_id;

    Long material_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id", referencedColumnName = "material_id", insertable = false, updatable = false)
    Material material;

    int group;

    int index;

    public EnteryStockPlace(Long entery_stock_place_id, Long material_id, int group, int index) {
        this.entery_stock_place_id = entery_stock_place_id;
        this.material_id = material_id;
        this.group = group;
        this.index = index;
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
        return "EnteryStockPlace{" +
                "entery_stock_place_id=" + entery_stock_place_id +
                ", material_id=" + material_id +
                ", group=" + group +
                ", index=" + index +
                '}';
    }
}
