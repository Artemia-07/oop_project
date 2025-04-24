package com.ecommerce;

import java.time.LocalDateTime;

public class Payment {
    private String paymentID;
    private double amount;
    private String paymentMethod; 
    private LocalDateTime paymentDate;
    private String status; 
    private Order order; 

    public Payment(String paymentMethod, double amount, Order order) {
        this.paymentID = "PAY-" + System.currentTimeMillis();
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.order = order;
        this.paymentDate = LocalDateTime.now();
        this.status = "Pending";
    }

    public void processPayment() {
        if (status.equals("Pending")) {
            boolean paymentSuccess = Math.random() > 0.2; 
            
            if (paymentSuccess) {
                this.status = "Completed";
                System.out.println("Payment processed successfully for order #" + order.getOrderID());
                order.updateStatus("Paid");
            } else {
                this.status = "Failed";
                System.out.println("Payment failed for order #" + order.getOrderID());
            }
        } else {
            throw new IllegalStateException("Payment already processed");
        }
    }

    public void refundPayment() {
        if (status.equals("Completed")) {
            this.status = "Refunded";
            System.out.println("Payment refunded for order #" + order.getOrderID());
            order.updateStatus("Refunded");
        } else {
            throw new IllegalStateException("Cannot refund payment in current state: " + status);
        }
    }

    public String getPaymentID() { return paymentID; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public String getStatus() { return status; }
    public Order getOrder() { return order; }

    @Override
    public String toString() {
        return "Payment ID: " + paymentID +
               "\nAmount: $" + String.format("%.2f", amount) +
               "\nMethod: " + paymentMethod +
               "\nDate: " + paymentDate +
               "\nStatus: " + status +
               "\nFor Order: #" + order.getOrderID();
    }
}