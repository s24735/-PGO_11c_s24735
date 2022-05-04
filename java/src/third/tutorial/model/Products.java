package src.third.tutorial.model;

public class Products {
    private final String name;
    private final ProductType productType;
    private final double price;
    private int quantity;

    public Products(String name, ProductType productType, double price, int quantity) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean sell(int quantityToRemove) {
        if ((quantity - quantityToRemove) >= 0) {
            quantity = quantity - quantityToRemove;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {

        return isAvailable;
    }
}
