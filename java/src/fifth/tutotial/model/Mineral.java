package src.fifth.tutotial.model;

import src.fifth.tutotial.exception.InvalidDataException;

public class Mineral extends Ingredient {
    protected int power = 0;


    public Mineral(String name, int baseReagent, int power) {
        super(name, baseReagent);
        validAndSetPower(power);
    }

    public int getPower() {
        return power;
    }

    public void validAndSetPower(int power) {
        if (power >= 0) {
            this.power = power;
        } else {
            throw new InvalidDataException("Power must be greater than 0");
        }
    }

    public int getReagent() {
        return (super.getReagent() + getPower());
    }
}
