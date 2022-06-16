package src.fifth.tutotial.model;

import src.fifth.tutotial.Logger;
import src.fifth.tutotial.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.List;

public class Elixir {
    private String name;
    private boolean isCreated;
    private final List<Ingredient> ingredients;
    private Liquid catalyst;
    private int power;

    public Elixir(String name) {
        ingredients = new ArrayList<>();
        validAndSetName(name);
    }

    public void Create() {
        if (isCreated()) {
            throw new InvalidDataException("Elixir already exists");
        }
        else if (catalyst == null) {
            throw new InvalidDataException("Elixir don't have catalyst");
        }
        else {
            powerUpdate();
            this.isCreated = true;
        }
    }

    public int getPower() {
        if (isCreated()) {
            throw new InvalidDataException("Elixir is not created yet.");
        } else {
            return power;
        }
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void removeIngredient(Ingredient o) {
        if (!isCreated) {
            ingredients.remove(o);
            powerUpdate();
        }
        else {
            throw new InvalidDataException("Cannot remove ingredient because it does not exist");
        }
    }

    private void powerUpdate() {
        int power = 0;
        if (catalyst == null) {
            throw new InvalidDataException("No catalysts");
        }
        else {
            if (ingredients.size() > 0) {
                for (Ingredient ingredient : ingredients) {
                    power += ingredient.getReagent();
                }
            }
            if (catalyst.getReagent() > 0) {
                power = power / catalyst.getReagent();
            } else {
                power = 0;
            }
        }
        this.power = power;
    }

    public void addIngredient(Ingredient o) {
        if (!isCreated) {
            ingredients.add(o);
            powerUpdate();
        } else {
            throw new InvalidDataException("Function unavailable when Elixir was created");
        }
    }

    public void print() {
        Logger.log("Elixir: " + getName());
        Logger.log("Ingredients: " + ingredients.size());
        for (Ingredient ingredient : ingredients) {
            Logger.logWithoutEnter("===> ");
            ingredient.print();
        }
        if (getCatalyst() == null) {
            Logger.log("Attention: No catalysts");
        } else {
            Logger.logWithoutEnter("Catalyst: ");
            getCatalyst().print();
        }
        if (isCreated()) {
            Logger.log("Elixir is created");
        } else {
            Logger.log("Elixir not created, current power: " + getPower());
        }
    }

    public Liquid getCatalyst() {
        return catalyst;
    }

    public String getName() {
        return name;
    }

    public void validAndSetName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidDataException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public void validAndSetCatalyst(Liquid catalyst) {
        if (isCreated()) {
            throw new InvalidDataException("Catalyst already exists");
        } else {
            this.catalyst = catalyst;
            powerUpdate();
        }
    }
}
