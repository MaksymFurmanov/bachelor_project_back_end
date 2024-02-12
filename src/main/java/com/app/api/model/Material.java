package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_seq_gen")
    @SequenceGenerator(name = "material_seq_gen", sequenceName = "material_seq_gen", allocationSize = 1)
    Long material_id;

    String supplier;

    String name;

    int volume;

    String pallet_color;

    String per_pallet;

    String date_of_order;

    String arriving_date;

    public Material(Long material_id, String supplier, String name, int volume, String pallet_color,
                    String per_pallet, String date_of_order, String arriving_date) {
        this.material_id = material_id;
        this.supplier = supplier;
        this.name = name;
        this.volume = volume;
        this.pallet_color = pallet_color;
        this.per_pallet = per_pallet;
        this.date_of_order = date_of_order;
        this.arriving_date = arriving_date;
    }

    public Material() {}

    public Long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Long material_id) {
        this.material_id = material_id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPer_pallet() {
        return per_pallet;
    }

    public void setPer_pallet(String per_pallet) {
        this.per_pallet = per_pallet;
    }

    public String getDate_of_order() {
        return date_of_order;
    }

    public void setDate_of_order(String date_of_order) {
        this.date_of_order = date_of_order;
    }

    public String getArriving_date() {
        return arriving_date;
    }

    public void setArriving_date(String arriving_date) {
        this.arriving_date = arriving_date;
    }

    @Override
    public String toString() {
        return "Material{" +
                "material_id=" + material_id +
                ", supplier='" + supplier + '\'' +
                ", name='" + name + '\'' +
                ", volume=" + volume +
                ", pallet_color='" + pallet_color + '\'' +
                ", per_pallet='" + per_pallet + '\'' +
                ", date_of_order='" + date_of_order + '\'' +
                ", arriving_date='" + arriving_date + '\'' +
                '}';
    }
}
