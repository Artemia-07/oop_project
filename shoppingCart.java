    package com.ecommerce;

    import java.util.ArrayList;
    import java.util.List;

    public class ShoppingCart {
        private int cartID;
        private LocalDate createdDate;
        private List<Product> items = new ArrayList<>();

        public ShoppingCart(int cartID) {
            this.cartID = cartID;
            this.createdDate = LocalDate.now(); 
        }

        public void addItem(Product product) { 
            items.add(product); 
        }
        public void removeItem(Product product){
            items.remove(product);
        }
        public void clearCart(){
            cart.clear();
            System.out.println("Cart cleared.");
        }
        public int getCartID() { return cartID; }
        public LocalDate getCreatedDate() { return createdDate; }
    }