package com.ecommerce;

public class Admin extends User {
    private int adminID;
    private String email;
    private String adminName;

    public Admin(int userID, String password, int adminID, String email, String adminName) {
        super(userID, password); 
        this.adminID = adminID;
        this.email = email;
        this.adminName = adminName;
    }

    public void manageOrder(Order order, String newStatus) {
        order.updateStatus(newStatus); 
        System.out.println("Admin " + adminName + " updated Order #" + order.getOrderID() + " to: " + newStatus);
    }

    public int getAdminID() { return adminID; }
    public String getEmail() { return email; }
    public String getAdminName() { return adminName; }
}