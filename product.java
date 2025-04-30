package com.ecommerce;

public class Product{
    private int productID;
    private String productName;
    private String category;
    private String description;
    private int price;
    private Stock stock;

    public Product(int productID, String productName, String category, String description, int price, Stock stock){
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    
    public void updateStock(Stock stock){
        stock.updateStatus(newStatus); 
        System.out.println("Updated stock #" + order.getQuantity() + " to: " + newStatus);
    }

    public int getProductID() { return productID; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
}