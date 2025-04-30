package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Vendor extends User {
    private int vendorID;
    private String vendorName;
    private String storeName;
    private List<Product> products;

    public Vendor(int userID, String firstName, String lastName, String password, int vendorID, String vendorName, String storeName, String products) {
        super(userID, firstName, lastName, password);
        this.vendorName = vendorName;
        this.vendorID = vendorID;
        this.storeName = storeName;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
            System.out.println("Added product: " + product.getProductName());
        }
    }

    public void updateProduct(Product product, String newName, double newPrice) {
        if (products.contains(product)) {
            product.setProductName(newName);
            product.setPrice(newPrice);
            System.out.println("Updated product ID#" + product.getProductID());
        }
    }

    public void viewPurchases() {
        System.out.println("Purchase history for " + storeName + ":");
        products.forEach(p -> System.out.println("- " + p.getProductName()));
    }

    public int getVendorID() { return vendorID; }
    public String getVendorName() { return vendorName; }
    public String getStoreName() { return storeName; }
    public List<Product> getProducts() { return new ArrayList<>(products); }
}