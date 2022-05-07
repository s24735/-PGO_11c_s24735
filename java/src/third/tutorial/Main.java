package src.third.tutorial;

import src.third.tutorial.model.Person;
import src.third.tutorial.model.ProductType;
import src.third.tutorial.model.Products;
import src.third.tutorial.model.Storage;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Products carrot = new Products("Marchewka", ProductType.CONSUMABLE, 2.99, 10);
        Products phone = new Products("Iphone 13 PRO 256 GB", ProductType.ELECTRONIC, 5699.99, 1);
        Products tv = new Products("SAMSUNG SADUH1231", ProductType.ELECTRONIC, 9999.99, 1);
        Person mariusz = new Person("Mariusz", "Kwiatkowski", 10.00, 3432.99);

        Storage storage1 = new Storage(20);
        Storage storage2 = new Storage(444);
        phone.addToStorage(storage1);

        Person agata = new Person("Agata", "Nowak", 50.00, 12034.55);

        agata.makeOrder(Arrays.asList(tv, phone));
        mariusz.makeOrder(carrot);
        mariusz.makeOrder(carrot);

        agata.buyByCard();
        mariusz.buyInCash();
    }
}
