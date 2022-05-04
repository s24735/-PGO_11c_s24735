package src.third.tutorial;

import src.third.tutorial.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static int id = 0;
    private double totalPrice;
    private long totalDeliveryTime;
    private List<Products> products = new ArrayList<>();

    public ShoppingCart() {
        id++;
    }

    public void addToCart(List<Products> products) {
        for (Products p : products) {
            totalPrice += p.getPrice() * p.getQuantity();
            totalDeliveryTime += p.
        }
        this.products.addAll(products);
    }

    public void addToCart(Products product) {
        this.products.add(product);
    }

    public void sell() {

    }

    public static int getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public long getTotalDeliveryTime() {
        return totalDeliveryTime;
    }

    public List<Products> getProducts() {
        return products;
    }

    public List<Products> notAvailableProducts() {
        List<Products> notAvailableProducts = new ArrayList<>();
        products.forEach(p -> {
            if (!p.isAvailable()) {
                notAvailableProducts.add(p);
            }
        });
        return notAvailableProducts;
    }
}
