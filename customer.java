package com.ecommerce;

public class Customer extends User {\
    private int customerID;
    private String customerName;
    private String email;
    private String address;
    private String creditCard;
    private ShoppingCart cart;

    public Customer(int userID, String firstName, String lastName, String password, String name) {
        super(userID, firstName, lastName, password);
        this.customerName = name;
        this.email = email;
        this.customerID = customerID;
        this.address = address;
        this.creditCard = creditCard;
        this.cart = new ShoppingCart();
    }

    public void addItemToCart() { 
         
    }
    public void updateProfile() { 
         
    }
    public void checkout() { 
        if()
        System.out.println("Order placed by " + customerName); 
    }
}