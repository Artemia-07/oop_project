package com.ecommerce;

public class Customer extends User {
    private int customerID;
    private String email;
    private String address;
    private String creditCardInfo; // Renamed for security clarity
    private ShoppingCart cart;

    public Customer(int userID, String firstName, String lastName, String password,
                  int customerID, String email, String address) {
        super(userID, firstName, lastName, password);
        this.customerID = customerID;
        this.email = email;
        this.address = address;
        this.cart = new ShoppingCart(generateCartId()); // Initialize with unique ID
    }

    public void addItemToCart(Product product, int quantity) {
        if (product != null && quantity > 0) {
            // Add the product 'quantity' times to the cart
            for (int i = 0; i < quantity; i++) {
                cart.addItem(product);
            }
            System.out.println(quantity + " x " + product.getProductName() + " added to cart");
        } else {
            throw new IllegalArgumentException("Invalid product or quantity");
        }
    }

    public void updateProfile(String newEmail, String newAddress, String newPassword) {
        if (newEmail != null && !newEmail.isEmpty()) {
            this.email = newEmail;
        }
        if (newAddress != null && !newAddress.isEmpty()) {
            this.address = newAddress;
        }
        if (newPassword != null && newPassword.length() >= 8) {
            setPassword(newPassword);
        }
    }

    public Order checkout() {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cannot checkout with empty cart");
        }
        
        Order order = new Order(generateOrderId(), this);
        
        // Convert cart items to order items with quantities
        for (Product product : cart.getItems()) {
            int quantity = (int) cart.getItems().stream()
                                  .filter(p -> p.getProductID() == product.getProductID())
                                  .count();
            order.addItem(product, quantity);
        }
        
        cart.clearCart();
        System.out.println("Order #" + order.getOrderID() + " placed by " + getFullName());
        return order;
    }

    // Getters
    public int getCustomerID() { return customerID; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public ShoppingCart getCart() { return cart; }

    // Secure credit card handling
    public void setCreditCard(String encryptedCardInfo) {
        if (encryptedCardInfo != null && !encryptedCardInfo.isEmpty()) {
            this.creditCardInfo = encryptedCardInfo;
        }
    }

    // Helper methods
    private int generateOrderId() {
        return (int) (System.currentTimeMillis() % 1000000);
    }
    
    private int generateCartId() {
        return (int) (System.currentTimeMillis() % 10000);
    }

    public String getFullName() {
        return ;
    }
}