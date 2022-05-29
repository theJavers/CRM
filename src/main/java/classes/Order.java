package classes;

import enums.Industry;
import enums.Products;

public class Order {
    private final int id;
    private static int counter = 1;

    private Products product;
    private int quantity;

    public Order(int quantity) {
        this.id = counter++;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
