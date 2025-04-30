package com.ecommerce;

import java.time.LocalDate;
import com.ecommerce.User;
import com.ecommerce.Product;
import com.ecommerce.Vendor;
import com.ecommerce.Admin;
import com.ecommerce.ShoppingCart;
import com.ecommerce.Payment;
import com.ecommerce.Customer;
import com.ecommerce.Shipment;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the system
        System.out.println("=== E-Commerce System Startup ===");

        // 2. Create products
        Product laptop = new Product(101, "Premium Laptop", "Electronics", 
                                   "16GB RAM, 1TB SSD", 1299.99, new Stock(50, "WAREHOUSE-1"));
        Product mouse = new Product(102, "Gaming Mouse", "Accessories", 
                                  "RGB, 8000DPI", 59.99, new Stock(200, "WAREHOUSE-2"));

        // 3. Create users
        Admin admin = new Admin(1, "admin123", 901, "admin@store.com", "System Administrator");
        Vendor vendor = new Vendor(2, "vendor123", "Tech", "Supplies", 501, "Tech Haven");
        Customer customer = new Customer(3, "Alice", "Johnson", "alice123", 
                                      3001, "alice@email.com", "123 Main St, City");

        // 4. Vendor adds products
        vendor.addProduct(laptop);
        vendor.addProduct(mouse);
        System.out.println("\nVendor '" + vendor.getStoreName() + "' has these products:");
        vendor.getProducts().forEach(p -> System.out.println("- " + p.getProductName()));

        // 5. Customer shops
        System.out.println("\nCustomer '" + customer.getFullName() + "' is shopping:");
        customer.addItemToCart(laptop, 1);
        customer.addItemToCart(mouse, 2);

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
        System.out.println("Products in system: " + Product.getTotalProducts());
        System.out.println("Active orders: " + Order.getTotalOrders());
        System.out.println("Current revenue: $" + Payment.getTotalRevenue());
    }
}
