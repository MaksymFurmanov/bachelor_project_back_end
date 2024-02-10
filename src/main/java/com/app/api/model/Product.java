package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long test_id;

    String name;

    String type;

    int per_pallet;

    String pallet_color;

    String quality_standards;

    String img;

    public Product(Long test_id, String name, String type,
                   int per_pallet, String pallet_color,
                   String quality_standards, String img) {
        this.test_id = test_id;
        this.name = name;
        this.type = type;
        this.per_pallet = per_pallet;
        this.pallet_color = pallet_color;
        this.quality_standards = quality_standards;
        this.img = img;
    }

    public Product() {}

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPer_pallet() {
        return per_pallet;
    }

    public void setPer_pallet(int per_pallet) {
        this.per_pallet = per_pallet;
    }

    public String getPallet_color() {
        return pallet_color;
    }

    public void setPallet_color(String pallet_color) {
        this.pallet_color = pallet_color;
    }

    public String getQuality_standards() {
        return quality_standards;
    }

    public void setQuality_standards(String quality_standards) {
        this.quality_standards = quality_standards;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" +
                "test_id=" + test_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", per_pallet=" + per_pallet +
                ", pallet_color='" + pallet_color + '\'' +
                ", quality_standards='" + quality_standards + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
