package com.example.mytestapp;

import java.io.Serializable;

public class dataModel implements Serializable {

    public dataModel() {
    }

    private String name;
    private double total,price;
    private int quan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public dataModel(String name, double price, int quan) {

        this.name = name;
        this.price = price;
        this.quan = quan;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }
}
