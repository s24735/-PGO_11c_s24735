package src.fifth.tutotial.model;

import src.fifth.tutotial.exception.InvalidDataException;

public class Liquid extends Ingredient {
    protected int dissolubility;

    public Liquid(String name, int baseReagent, int dissolubility) {
        super(name, baseReagent);
        validAndSetDissolubility(dissolubility);
    }

    public int getDissolubility() {
        return dissolubility;
    }

    public void validAndSetDissolubility(int dissolubility) {
        if (dissolubility >= 0 && dissolubility <= 100) {
            this.dissolubility = dissolubility;
        }
        else {
            throw new InvalidDataException("Dissolubility must be greater than 0 and lower than 100.");
        }
    }

    public int getReagent() {
        return (int) (super.getReagent() * getDissolubility() * 0.01);
    }
}
