package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Vendor extends User {
    private int vendorID;
    private String vendorName;
    private String storeName;
    private List<Product> products;

    public Vendor(int vendorID, String firstName, String lastName, String vendorName, String storeName, String products) {
        super(userID, firstName, lastName, password);
        this.vendorName = vendorName;
        this.vendorID = vendorID;
        this.storeName = storeName;
    }

    public void addProduct() { 
        product.add()
    }
    public void updateProduct() {
        product.updateStatus(newStatus);
        System.out.println("Updated Product ID#" + getProductID() + "to: " + newStatus);
    }
    public void viewPurchase() { 
         
    }
}