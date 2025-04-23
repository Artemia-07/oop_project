package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) { 
        items.add(product); 
    }
}