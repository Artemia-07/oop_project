package com.ecommerce;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the system
        System.out.println("=== E-Commerce System Startup ===");

        // 2. Create products
        Product laptop = new Product(101, "Premium Laptop", "Electronics",
                                   "16GB RAM, 1TB SSD", 1299.99, new Stock(50, "WAREHOUSE-1"));
        Product mouse = new Product(102, "Gaming Mouse", "Accessories",
                                  "RGB, 8000DPI", 59.99, new Stock(200, "WAREHOUSE-2"));

        // 3. Create users - Fixed constructors
        Admin admin = new Admin(1, "System", "Administrator", "admin123", 
                              901, "admin@store.com", "Admin User");
        Vendor vendor = new Vendor(2, "Tech", "Vendor", "vendor123", 
                                501, "Tech Vendor", "Tech Haven", "");
        Customer customer = new Customer(3, "Alice", "Johnson", "alice123",
                                      3001, "alice@email.com", "123 Main St, City");

        // 4. Vendor adds products
        vendor.addProduct(laptop);
        vendor.addProduct(mouse);
        System.out.println("\nVendor '" + vendor.getStoreName() + "' has these products:");
        vendor.getProducts().forEach(p -> System.out.println("- " + p.getProductName() + " ($" + p.getPrice() + ")"));

        // 5. Customer shops
        System.out.println("\nCustomer '" + customer.getFirstName() + " " + customer.getLastName() + "' is shopping:");
        customer.addItemToCart(laptop, 1);
        customer.addItemToCart(mouse, 2);

        // Display cart contents
        System.out.println("\nCart Contents:");
        customer.getCart().getItems().forEach(p -> 
            System.out.println("- " + p.getProductName() + " ($" + p.getPrice() + ")"));
        System.out.println("Cart Total: $" + customer.getCart().calculateTotal());

        // 6. Checkout process
        System.out.println("\n=== Checkout Process ===");
        Order order = customer.checkout();
        Payment payment = new Payment("Credit Card", order.calculateTotal(), order);
        payment.processPayment();

        // 7. Admin processes order
        if (payment.getStatus().equals("Completed")) {
            admin.manageOrder(order, "Approved");
            Shipment shipment = new Shipment(order, "UPS", 9.99, customer.getAddress());
            shipment.updateStatus("Shipped");
            
            System.out.println("\nShipment Details:");
            System.out.println(shipment.track());
        }

        // 8. System status
        System.out.println("\n=== System Status ===");
        System.out.println("Products:");
        System.out.println("- " + laptop.getProductName() + ": " + laptop.getStock().getQuantity() + " in stock");
        System.out.println("- " + mouse.getProductName() + ": " + mouse.getStock().getQuantity() + " in stock");
        
        System.out.println("\nOrder Status:");
        System.out.println("- Order #" + order.getOrderID() + ": " + order.getStatus());
        System.out.println("- Total: $" + order.calculateTotal());
        
        System.out.println("\nPayment Status:");
        System.out.println("- " + payment.getPaymentID() + ": " + payment.getStatus());
        
        // Call static counters
        System.out.println("\nSystem Totals:");
        new Product(0, "", "", "", 0, null).getTotalProducts();
        new Order(0, null).getTotalOrders();
        new Payment("", 0, null).getTotalRevenue();
    }
}