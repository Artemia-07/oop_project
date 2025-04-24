package com.ecommerce;

public class Customer extends User {\
    private int customerID;
    private String customerName;
    private String email;
    private String address;
    private String creditCard;
    private ShoppingCart cart;

    public Customer(int userID, String password, String name) {
        super(userID, password);
        this.customerName = name;
        this.cart = new ShoppingCart();
    }

    public void addItemToCart() { 
         
    }
    public void updateProfile() { 
         
    }
    public void checkout() { 
        System.out.println("Order placed by " + customerName); 
    }
}