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
            computeDeliveryTime(p);
        }
        this.products.addAll(products);
    }

    public void addToCart(Products product) {
        computeDeliveryTime(product);
        this.products.add(product);
    }

    private void computeDeliveryTime(Products p) {
        totalPrice += p.getPrice();
        long deliveryTime = p.getTotalDeliveryTime();
        if (deliveryTime == -1) {
            throw new RuntimeException("Product is not available");
        }
        totalDeliveryTime += deliveryTime;
    }

    public void sell() {
        products.forEach(p -> p.sell(1));
    }

    public double getTotalPrice() {
        return totalPrice;
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
