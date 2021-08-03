package com.example.tugasmagang.model;

import javax.persistence.*;

@Entity
@Table(name = "courier", schema = "public")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courier_id;
    private int coverage_city;
    private String courier_name, courier_type;

    public Courier() {}

    public Courier(int courier_id, int coverage_city, String courier_name, String courier_type) {
        this.courier_id = courier_id;
        this.coverage_city = coverage_city;
        this.courier_name = courier_name;
        this.courier_type = courier_type;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public int getCoverage_city() {
        return coverage_city;
    }

    public void setCoverage_city(int coverage_city) {
        this.coverage_city = coverage_city;
    }

    public String getCourier_name() {
        return courier_name;
    }

    public void setCourier_name(String courier_name) {
        this.courier_name = courier_name;
    }

    public String getCourier_type() {
        return courier_type;
    }

    public void setCourier_type(String courier_type) {
        this.courier_type = courier_type;
    }
}
