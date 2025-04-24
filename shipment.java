package com.ecommerce;

import java.time.LocalDateTime;
import java.util.UUID;

public class Shipment {
    private String shipmentID;
    private Order order;
    private String carrier;
    private String trackingNumber;
    private LocalDateTime shipmentDate;
    private LocalDateTime estimatedDelivery;
    private String status; 
    private double shippingCost;
    private String shippingAddress;

    public Shipment(Order order, String carrier, double shippingCost, String shippingAddress) {
        this.shipmentID = "SHIP-" + UUID.randomUUID().toString().substring(0, 8);
        this.order = order;
        this.carrier = carrier;
        this.trackingNumber = generateTrackingNumber(carrier);
        this.shipmentDate = LocalDateTime.now();
        this.estimatedDelivery = calculateEstimatedDelivery();
        this.status = "Preparing";
        this.shippingCost = shippingCost;
        this.shippingAddress = shippingAddress;
    }

    private String generateTrackingNumber(String carrier) {
        return carrier.substring(0, 3).toUpperCase() + 
               java.time.LocalDate.now().getYear() + 
               UUID.randomUUID().toString().substring(0, 10).toUpperCase();
    }

    private LocalDateTime calculateEstimatedDelivery() {
        return shipmentDate.plusDays(3 + (int)(Math.random() * 5));
    }

    public void updateStatus(String newStatus) {
        if (status.equals("Delivered") && !newStatus.equals("Returned")) {
            throw new IllegalStateException("Cannot modify status of delivered shipment");
        }
        this.status = newStatus;
        
        if (newStatus.equals("Shipped")) {
            order.updateStatus("Shipped");
        } else if (newStatus.equals("Delivered")) {
            order.updateStatus("Delivered");
        }
    }

    public String track() {
        return "Shipment " + shipmentID + 
               "\nCarrier: " + carrier +
               "\nTracking: " + trackingNumber +
               "\nStatus: " + status +
               "\nShipped on: " + shipmentDate +
               "\nEstimated delivery: " + estimatedDelivery +
               "\nTo: " + shippingAddress;
    }

    public void processReturn(String reason) {
        if (!status.equals("Delivered")) {
            throw new IllegalStateException("Can only return delivered shipments");
        }
        this.status = "Returned";
        order.updateStatus("Return Initiated");
        System.out.println("Return processed for order #" + order.getOrderID() + ". Reason: " + reason);
    }

    public String getShipmentID() { return shipmentID; }
    public String getTrackingNumber() { return trackingNumber; }
    public LocalDateTime getShipmentDate() { return shipmentDate; }
    public String getStatus() { return status; }
    public double getShippingCost() { return shippingCost; }
    public Order getOrder() { return order; }

    @Override
    public String toString() {
        return "Shipment ID: " + shipmentID +
               "\nFor Order: #" + order.getOrderID() +
               "\nStatus: " + status +
               "\nCarrier: " + carrier +
               "\nTracking: " + trackingNumber +
               "\nCost: $" + String.format("%.2f", shippingCost);
    }
}