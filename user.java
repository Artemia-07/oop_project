package com.ecommerce;

public class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String password;
    private String status;

    public User(int userID, String firstName, String lastName, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.status = "active";
    }

    public void setPassword(String password) {
        if (newPassword.length() >= 8) {
            this.password = newPassword;
        }
    }
    
    public void login() { System.out.println("User logged in."); }
    public void logout() { System.out.println("User logged out."); }

    public int getUserID() { return userID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}