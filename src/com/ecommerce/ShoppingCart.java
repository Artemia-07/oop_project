package com.ecommerce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int cartID;
    private LocalDate createdDate;
    private List<Product> items;

    public ShoppingCart(int cartID) {
        this.cartID = cartID;
        this.createdDate = LocalDate.now();
        this.items = new ArrayList<>(); // Initialize the list
    }

    public void addItem(Product product) { 
        if (product != null) {
            items.add(product); 
        }
    }
    
    public void removeItem(Product product) {
        items.remove(product);
    }

    public void clearCart() {
        items.clear(); // Fixed: clearing 'items' instead of undefined 'cart'
        System.out.println("Cart cleared.");
    }

    public double calculateTotal() {
        return items.stream()
                   .mapToDouble(Product::getPrice)
                   .sum();
    }

    public List<Product> getItems() { return new ArrayList<>(items); }
    public int getCartID() { return cartID; }
    public LocalDate getCreatedDate() { return createdDate; }
}