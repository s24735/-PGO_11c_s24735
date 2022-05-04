package src.third.tutorial.model;

import src.third.tutorial.ShoppingCart;

import java.util.List;

public class Person {
    private String name;
    private String surname;
    private double moneyInCash;
    private double moneyOnCard;
    private ShoppingCart shoppingCart = new ShoppingCart();
    private List<ShoppingCart> history;

    public Person(String name, String surname, double moneyInCash, double moneyOnCard) {
        if (areFieldsValid(name, surname)) {
            this.name = name;
            this.surname = surname;
            this.moneyInCash = moneyInCash;
            this.moneyOnCard = moneyOnCard;
        }
        else {
            System.out.println("Invalid data given.");
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
        shoppingCart.addToCart(products);
    }

    public void makeOrder(Products product) {
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
                    money = money - shoppingCart.getTotalPrice();
                    history.add(shoppingCart);
                    shoppingCart = null;
                }
                else {
                    System.out.println("Don't have enough money.");
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
