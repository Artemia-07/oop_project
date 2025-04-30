package com.ecommerce;

public class Stock {
    private int quantity;
    private String location;

    public Stock(int quantity, String location) {
        this.quantity = quantity;
        this.location = location;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}