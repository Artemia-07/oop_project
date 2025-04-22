public class Main {
    
}

package com.library;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default: available
    }

    // Getters & Setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "📖 " + title + " by " + author + " (" + (isAvailable ? "Available" : "Borrowed") + ")";
    }
}