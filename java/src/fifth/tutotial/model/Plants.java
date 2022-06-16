package src.fifth.tutotial.model;

import src.fifth.tutotial.exception.InvalidDataException;

public class Plants extends Ingredient {
    protected int toxity;

    public Plants(String name, int baseReagent, int toxity) {
        super(name, baseReagent);
        validAndSetToxity(toxity);
    }

    public int getToxity() {
        return toxity;
    }

    public void validAndSetToxity(int toxity) {
        if (toxity >= 0) {
            this.toxity = toxity;
        } else {
            throw new InvalidDataException("Toxity must be greater than 0");
        }
    }

    public int getReagent() {
        if (getToxity() > 0) {
            return super.getReagent() * getToxity();
        } else {
            return super.getReagent();
        }
    }
}
