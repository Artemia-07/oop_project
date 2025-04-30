package com.ecommerce;

public class Customer extends User {\
    private int customerID;
    private String customerName;
    private String email;
    private String address;
    private String creditCard;
    private ShoppingCart cart;

    public Customer(int userID, String firstName, String lastName, String password, int customerID, String customerName, String email, String address, ) {
        super(userID, firstName, lastName, password);
        this.customerName = name;
        this.email = email;
        this.customerID = customerID;
        this.address = address;
        this.creditCard = creditCard;
        this.cart = new ShoppingCart();
    }

    public void addItemToCart(Product product, int quantity) {
        if (product != null && quantity > 0) {
            cart.addItem(product, quantity);
            System.out.println(quantity + " x " + product.getProductName() + " added to cart");
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
            setPassword(newPassword); // Uses parent class's setter
        }
    }

    public Order checkout() {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cannot checkout with empty cart");
        }
        
        Order order = new Order(generateOrderId(), this);
        order.setItems(cart.getItems());
        cart.clearCart();
        
        System.out.println("Order #" + order.getOrderID() + " placed by " + getFullName());
        return order;
    }

    public int getCustomerID() { return customerID; }
    public String getEmail() { return email; }
    public String getCustomerName() { return customerName; }
    public String getAddress() { return address; }
    public ShoppingCart getCart() { return cart; }

    public void setCreditCard(String encryptedCardInfo) {
        this.creditCardInfo = encryptedCardInfo;
    }

    private int generateOrderId() {
        return (int) (System.currentTimeMillis() % 1000000);
    }
}