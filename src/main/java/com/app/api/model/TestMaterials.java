package com.app.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tests_materials")
public class TestMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_materials_seq_gen")
    @SequenceGenerator(name = "test_materials_seq_gen", sequenceName = "test_materials_seq_gen", allocationSize = 1)
    Long test_id;

    Long material_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id", referencedColumnName = "material_id", insertable = false, updatable = false)
    Material material;

    int status;

    Boolean accepted;

    String document;

    public TestMaterials(Long test_id, Long material_id, int status, Boolean accepted, String document) {
        this.test_id = test_id;
        this.material_id = material_id;
        this.status = status;
        this.accepted = accepted;
        this.document = document;
    }

    public TestMaterials() {}

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public Long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Long material_id) {
        this.material_id = material_id;
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
        return "TestMaterials{" +
                "test_id=" + test_id +
                ", material_id=" + material_id +
                ", status='" + status + '\'' +
                ", accepted=" + accepted +
                ", document='" + document + '\'' +
                '}';
    }
}
