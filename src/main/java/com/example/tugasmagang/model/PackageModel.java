package com.example.tugasmagang.model;

import javax.persistence.*;

@Entity
@Table(name = "package", schema = "public")
public class PackageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private int package_id;
    @Column(name = "package_description")
    private String package_description;

    public PackageModel() {}

    public PackageModel(int package_id, String package_description) {
        this.package_id = package_id;
        this.package_description = package_description;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public String getPackage_description() {
        return package_description;
    }

    public void setPackage_description(String package_description) {
        this.package_description = package_description;
    }
}
