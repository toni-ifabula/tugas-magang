package com.example.tugasmagang.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction", schema = "public")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trx_id;
    private int trx_package, trx_city_src, trx_city_dst;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trx_package", referencedColumnName = "package_id", insertable = false, updatable = false)
    private PackageModel packageModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trx_city_src", referencedColumnName = "city_id", insertable = false, updatable = false)
    private CoverageCity coverageCitySrc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trx_city_dst", referencedColumnName = "city_id", insertable = false, updatable = false)
    private CoverageCity coverageCityDst;

    private String trx_type;
    private Date trx_date;

    public Transaction() {}

    public Transaction(int trx_id, int trx_package, int trx_city_src, int trx_city_dst, PackageModel packageModel, CoverageCity coverageCitySrc, CoverageCity coverageCityDst, String trx_type, Date trx_date) {
        this.trx_id = trx_id;
        this.trx_package = trx_package;
        this.trx_city_src = trx_city_src;
        this.trx_city_dst = trx_city_dst;
        this.packageModel = packageModel;
        this.coverageCitySrc = coverageCitySrc;
        this.coverageCityDst = coverageCityDst;
        this.trx_type = trx_type;
        this.trx_date = trx_date;
    }

    public int getTrx_id() {
        return trx_id;
    }

    public void setTrx_id(int trx_id) {
        this.trx_id = trx_id;
    }

    public int getTrx_package() {
        return trx_package;
    }

    public void setTrx_package(int trx_package) {
        this.trx_package = trx_package;
    }

    public int getTrx_city_src() {
        return trx_city_src;
    }

    public void setTrx_city_src(int trx_city_src) {
        this.trx_city_src = trx_city_src;
    }

    public int getTrx_city_dst() {
        return trx_city_dst;
    }

    public void setTrx_city_dst(int trx_city_dst) {
        this.trx_city_dst = trx_city_dst;
    }

    public PackageModel getPackageModel() {
        return packageModel;
    }

    public void setPackageModel(PackageModel packageModel) {
        this.packageModel = packageModel;
    }

    public CoverageCity getCoverageCitySrc() {
        return coverageCitySrc;
    }

    public void setCoverageCitySrc(CoverageCity coverageCitySrc) {
        this.coverageCitySrc = coverageCitySrc;
    }

    public CoverageCity getCoverageCityDst() {
        return coverageCityDst;
    }

    public void setCoverageCityDst(CoverageCity coverageCityDst) {
        this.coverageCityDst = coverageCityDst;
    }

    public String getTrx_type() {
        return trx_type;
    }

    public void setTrx_type(String trx_type) {
        this.trx_type = trx_type;
    }

    public Date getTrx_date() {
        return trx_date;
    }

    public void setTrx_date(Date trx_date) {
        this.trx_date = trx_date;
    }
}
