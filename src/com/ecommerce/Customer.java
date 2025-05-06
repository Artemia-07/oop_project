package com.ecommerce;

public class Customer extends User {
    private int customerID;
    private String email;
    private String address;
    private String creditCardInfo;
    private ShoppingCart cart;

    public Customer(int userID, String firstName, String lastName, String password,
                  int customerID, String email, String address) {
        super(userID, firstName, lastName, password);
        this.customerID = customerID;
        this.email = email;
        this.address = address;
        this.cart = new ShoppingCart(generateCartId());
        this.creditCardInfo = "";
    }

    public void addItemToCart(Product product, int quantity) {
        if (product != null && quantity > 0) {
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
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot checkout with empty cart");
        }
        
        Order order = new Order(generateOrderId(), this);
        
        for (Product product : cart.getItems()) {
            int quantity = (int) cart.getItems().stream()
                                  .filter(p -> p.getProductID() == product.getProductID())
                                  .count();
            order.addItem(product, quantity);
        }
        
        cart.clearCart();
        System.out.print("Order #" + order.getOrderID() + " placed by ");
        getFullName(); 
        return order;
    }

    public int getCustomerID() { return customerID; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public ShoppingCart getCart() { return cart; }
    public String getCreditCardInfo() { return creditCardInfo; } 

    public void setCreditCard(String encryptedCardInfo) {
        if (encryptedCardInfo != null && !encryptedCardInfo.isEmpty()) {
            this.creditCardInfo = encryptedCardInfo;
        }
    }

    private int generateOrderId() {
        return (int) (System.currentTimeMillis() % 1000000);
    }
    
    private int generateCartId() {
        return (int) (System.currentTimeMillis() % 10000);
    }

//     @Override
// public String getFullName() {
//     return super.getFullName(); // or getFirstName() + " " + getLastName();
//}
}