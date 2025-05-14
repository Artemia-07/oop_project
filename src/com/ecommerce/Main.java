package com.ecommerce;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the system
        System.out.println("=== E-Commerce System Startup ===");
        
        // 2. Create products
        Product phone = new Product(101, "Xiaomi 15 Ultra", "Electronics",
                                   "16GB RAM, 512GB SSD", 459.99, new Stock(150, "WAREHOUSE-1"));
        Product cooler = new Product(102, "Nubia RedMagic 6 Pro Magnetic Cell Phone Cooler", "Accessories",
                                  "9V, 30W, Graphene Cooling, 35dB", 69.99, new Stock(250, "WAREHOUSE-2"));

        // 3. Create users - Fixed constructors
        Admin admin = new Admin(1, "Mike", "Anderson", "admin123", 
                              201, "upandabove@store.com", "mikeanderson@hmail.com");
        Vendor vendor = new Vendor(2, "Jay", "Wong", "vendor123", 
                                301, "Gadget Vendor", "Gadget Galore", "");
        Customer customer = new Customer(3, "Alistair", "Mcreed", "customer123",
                                      4001, "alice@email.com", "123 Main St, Los Angeles");

        // 4. Vendor adds products
        vendor.addProduct(phone);
        vendor.addProduct(cooler);
        System.out.println("\nVendor '" + vendor.getStoreName() + "' has these products:");
        vendor.getProducts().forEach(p -> System.out.println("- " + p.getProductName() + " ($" + p.getPrice() + ")"));

        // 5. Customer shops
        System.out.println("\nCustomer '" + customer.getFirstName() + " " + customer.getLastName() + "' is shopping:");
        customer.addItemToCart(phone, 1);
        customer.addItemToCart(cooler, 2);

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
        System.out.println("- " + phone.getProductName() + ": " + phone.getStock().getQuantity() + " in stock");
        System.out.println("- " + cooler.getProductName() + ": " + cooler.getStock().getQuantity() + " in stock");
        
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

//          // ===== ERROR HANDLING DEMO =====
// System.out.println("\n=== Testing Error Handling ===");

// // Attempt to checkout with an empty cart
// Customer testCustomer = new Customer(4, "Test", "User", "test123", 
//                                    4002, "test@email.com", "456 Fake St");
// try {
//     System.out.println("Attempting checkout with empty cart...");
//     Order invalidOrder = testCustomer.checkout();  // This will throw an exception
// } catch (IllegalStateException e) {
//     System.out.println("ERROR: " + e.getMessage());  // Handle the exception
// }

// // Attempt to process payment for a cancelled order
// Order cancelledOrder = new Order(999, customer);
// cancelledOrder.updateStatus("Cancelled");
// try {
//     System.out.println("\nAttempting to ship cancelled order...");
//     Shipment invalidShipment = new Shipment(cancelledOrder, "FedEx", 12.99, customer.getAddress());
//     invalidShipment.updateStatus("Shipped");  // Will throw exception
// } catch (IllegalStateException e) {
//     System.out.println("ERROR: " + e.getMessage());
// }

    }
}