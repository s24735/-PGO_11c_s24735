package src.fifth.tutotial.model;

public class Ore extends Mineral {
    protected boolean metallic;

    public Ore(String name, int baseReagent, int power, boolean metallic) {
        super(name, baseReagent, power);
        this.metallic = metallic;
    }

    public int getReagent() {
        if (isMetallic()) {
            return super.getReagent();
        } else {
            return super.getReagent() / 2;
        }
    }

    public boolean isMetallic() {
        return metallic;
    }
}
