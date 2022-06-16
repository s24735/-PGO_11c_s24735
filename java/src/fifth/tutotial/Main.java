package src.fifth.tutotial;

import src.fifth.tutotial.model.*;

public class Main {


    public static void main(String[] args) {
        Water water = new Water("water", 3, 32, true);
        Alcohol alcohol = new Alcohol("alcohol", 56, 3, 65);
        Ore ore = new Ore("ore", 16, 26, true);
        Crystal crystal = new Crystal("crystal", 265, 12, 69);
        Flower flower = new Flower("flower", 45, 6);
        Plants plants = new Plants("plants", 5, 34);
        Plants plants2 = new Plants("plants2", 6, 17);
        Root root = new Root("root", 2, 6);


        Elixir elixir = new Elixir("Jaskółka");
        elixir.validAndSetCatalyst(alcohol);
        elixir.addIngredient(ore);
        elixir.addIngredient(plants);
        elixir.removeIngredient(ore);
        elixir.addIngredient(plants2);
        elixir.addIngredient(crystal);
        elixir.Create();
        elixir.print();
    }
}
