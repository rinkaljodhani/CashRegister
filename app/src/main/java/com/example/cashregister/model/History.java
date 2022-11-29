package com.example.cashregister.model;

import java.io.Serializable;

public class History extends Product implements Serializable {
    String date;
    public History(String name, double price, int qty,String date) {
        super(name, price, qty);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
