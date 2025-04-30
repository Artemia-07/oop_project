package com.ecommerce;

public class Product {
    private int productID;
    private String productName;
    private String category;
    private String description;
    private double price;  
    private Stock stock;

    public Product(int productID, String productName, String category, 
                 String description, double price, Stock stock) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    
    public void setProductName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.productName = newName;
        }
    }

    public void setPrice(double newPrice) {
        if (newPrice >= 0) { 
            this.price = newPrice;
        }
    }
    
    public void updateStock(Stock newStock) {
        if (newStock != null) {
            this.stock = newStock;
            System.out.println("Updated stock for product #" + productID + 
                              " - New quantity: " + newStock.getQuantity());
        }
    }

    public void updateStockQuantity(int newQuantity) {
        if (stock != null) {
            stock.setQuantity(newQuantity);
            System.out.println("Updated stock quantity for product #" + productID + 
                              " to: " + newQuantity);
        }
    }

    public int getProductID() { return productID; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public Stock getStock() { return stock; }

//     @Override
//     public String toString() {
//         return String.format("Product #%d: %s (%s) - $%.2f | Stock: %d @ %s",
//                            productID, productName, category, 
//                            price, stock.getQuantity(), stock.getLocation());
//     }
}