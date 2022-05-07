package src.third.tutorial.model;

import src.third.tutorial.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private double moneyInCash;
    private double moneyOnCard;
    private ShoppingCart shoppingCart = new ShoppingCart();
    private List<ShoppingCart> history = new ArrayList<>();

    public Person(String name, String surname, double moneyInCash, double moneyOnCard) {
        if (areFieldsValid(name, surname)) {
            this.name = name;
            this.surname = surname;
            this.moneyInCash = moneyInCash;
            this.moneyOnCard = moneyOnCard;
        }
        else {
            throw new RuntimeException("Invalid data given.");
        }
    }

    private boolean areFieldsValid(String... fields) {
        for (String field : fields) {
            if (field == null || field.equals("")) {
                return false;
            }
        }
        return true;
    }

    public void makeOrder(List<Products> products) {
        System.out.println(name + " adding to basket new products");
        products.forEach(System.out::print);
        System.out.println();
        shoppingCart.addToCart(products);
    }

    public void makeOrder(Products product) {
        System.out.println(name + " adding to basket new products");
        System.out.println(product.toString());
        System.out.println();
        shoppingCart.addToCart(product);
    }

    public void buyByCard() {
        moneyInCash = buyBy(moneyInCash);
    }

    public void buyInCash() {
        moneyInCash = buyBy(moneyInCash);
    }

    private double buyBy(double money) {
        if (shoppingCart.getProducts().isEmpty()) {
            System.out.println("Basket is empty.");
        }
        else {
            List<Products> notAvailableProducts = shoppingCart.notAvailableProducts();
            if (notAvailableProducts.isEmpty()) {
                if ((money - shoppingCart.getTotalPrice()) >= 0) {
                    System.out.println("");
                    money = money - shoppingCart.getTotalPrice();
                    shoppingCart.sell();
                    history.add(shoppingCart);
                    shoppingCart = new ShoppingCart();
                }
                else {
                    System.out.println(name + " don't have enough money.");
                }
            }
            else {
                System.out.println("You can't finish your shopping. Products bellow are not available:");
                notAvailableProducts.forEach(product -> System.out.println(product.getName()));
            }
        }

        return money;
    }
}
