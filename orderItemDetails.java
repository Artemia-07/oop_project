package com.ecommerce;

public class OrderItem {
    private int orderID;
    private int quantity;
    private double totalPrice;
    private Product product;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public void calculateTotalPrice() {
        this.totalPrice = product.getPrice() * quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateTotalPrice(); 
    }

    // @Override
    // public String toString() {
    //     return "OrderItem [Product: " + product.getProductName() + 
    //            ", Quantity: " + quantity + 
    //            ", Total: $" + totalPrice + "]";
    // }
}