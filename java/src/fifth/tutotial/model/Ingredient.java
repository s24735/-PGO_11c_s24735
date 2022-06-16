package src.fifth.tutotial.model;

import src.fifth.tutotial.Logger;
import src.fifth.tutotial.exception.InvalidDataException;

public class Ingredient {
    protected String name;
    private int baseReagent;

    public Ingredient(String name, int baseReagent) {
        setName(name);
        setBaseReagent(baseReagent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidDataException("name for ingredient is empty or is null");
        } else {
            this.name = name;
        }
    }

    protected int getReagent() {
        return baseReagent;
    }


    public void setBaseReagent(int baseReagent) {
        if (baseReagent >= 0) {
            this.baseReagent = baseReagent;
        } else {
            throw new InvalidDataException("baseReagent cannot be less than 0");
        }
    }

    public void print() {
        Logger.log(getName() + " [ reagent: " + this.getReagent() + " ]");
    }
}
