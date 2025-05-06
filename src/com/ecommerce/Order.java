package com.ecommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private Customer customer;
    private LocalDateTime orderDate;
    private LocalDateTime shippedDate;
    private String status; 
    private List<OrderItem> items = new ArrayList<>();
    private Payment payment;
    private Shipment shipment;
    private static int orderCount = 0;

    public Order(int orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = LocalDateTime.now();
        this.status = "Pending";
        orderCount++;
    }

    public void addItem(Product product, int quantity) {
        OrderItem item = new OrderItem(product, quantity);
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream()
                   .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                   .sum();
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        if ("Shipped".equals(newStatus)) {
            this.shippedDate = LocalDateTime.now();
        }
    }

    public void placeOrder() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot place empty order");
        }
        this.status = "Placed";
        System.out.println("Order #" + orderID + " placed successfully");
    }

    public void cancelOrder() {
        if ("Delivered".equals(status)) {
            throw new IllegalStateException("Cannot cancel delivered order");
        }
        this.status = "Cancelled";
    }

    public void getTotalOrders() {
        System.out.println("Total number of orders in system: " + orderCount);
    }

    public int getOrderID() { return orderID; }
    public Customer getCustomer() { return customer; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public List<OrderItem> getItems() { return new ArrayList<>(items); }
    public Payment getPayment() { return payment; }
    public Shipment getShipment() { return shipment; }

    public void setPayment(Payment payment) { this.payment = payment; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }

    // @Override
    // public String toString() {
    //     return "Order #" + orderID + 
    //            "\nCustomer: " + customer.getFirstName() + 
    //            "\nDate: " + orderDate + 
    //            "\nStatus: " + status + 
    //            "\nTotal: $" + calculateTotal();
    // }
}