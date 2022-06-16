package src.fifth.tutotial.model;

import src.fifth.tutotial.exception.InvalidDataException;

public class Crystal extends Mineral {
    protected int magicPower;

    public Crystal(String name, int baseReagent, int power, int magicPower) {
        super(name, baseReagent, power);
        setMagicPower(magicPower);
    }

    public int getReagent() {
        return super.getReagent() + getMagicPower();
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        if (magicPower >= 0) {
            this.magicPower = magicPower;
        } else {
            throw new InvalidDataException("Magic Power must be greater than 0");
        }
    }
}
