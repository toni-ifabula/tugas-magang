package com.example.tugasmagang.model;

import java.sql.Date;

public class TransactionAssignment {

    private int assign_id, trx_id, courier_id;
    private Date assign_date;

    public TransactionAssignment(int assign_id, int trx_id, int courier_id, Date assign_date) {
        this.assign_id = assign_id;
        this.trx_id = trx_id;
        this.courier_id = courier_id;
        this.assign_date = assign_date;
    }

    public int getAssign_id() {
        return assign_id;
    }

    public void setAssign_id(int assign_id) {
        this.assign_id = assign_id;
    }

    public int getTrx_id() {
        return trx_id;
    }

    public void setTrx_id(int trx_id) {
        this.trx_id = trx_id;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public Date getAssign_date() {
        return assign_date;
    }

    public void setAssign_date(Date assign_date) {
        this.assign_date = assign_date;
    }
}
