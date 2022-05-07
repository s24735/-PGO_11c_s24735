package src.third.tutorial.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private final String name;
    private final ProductType productType;
    private final double price;
    private int quantity;
    private List<Storage> additionalProductInStorages = new ArrayList<>();

    public Products(String name, ProductType productType, double price, int quantity) {
        if (areFieldsValid(name) && areFieldsValid(productType)) {
            this.name = name;
            this.productType = productType;
            this.price = price;
            this.quantity = quantity;
        }
        else {
            throw new RuntimeException("Invalid data given.");
        }
    }

    private boolean areFieldsValid(ProductType productType) {
        return productType != null;
    }

    private boolean areFieldsValid(String... fields) {
        for (String field : fields) {
            if (field == null || field.equals("")) {
                return false;
            }
        }
        return true;
    }

    public void sell(int quantityToRemove) {
        if ((quantity - quantityToRemove) >= 0) {
            quantity = quantity - quantityToRemove;
        }
        else {
            throw new RuntimeException("Error occurred. Some products are not available");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return !additionalProductInStorages.isEmpty() || quantity > 0;
    }

    public void addToStorage(Storage storage1) {
        additionalProductInStorages.add(storage1);
    }

    public long getTotalDeliveryTime() {
        if (quantity == 0) {
            if (isAvailable()) {
                Storage storage = additionalProductInStorages.stream()
                        .findAny()
                        .orElse(null);
                if (storage != null) {
                    long deliveryTime = storage.getDeliveryTime();
                    additionalProductInStorages.remove(storage);
                    return deliveryTime;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                '}';
    }
}
