package src.fifth.tutotial.model;

public class Water extends Liquid {
    protected boolean distilated;

    public Water(String name, int baseReagent, int dissolubility, boolean distilated) {
        super(name, baseReagent, dissolubility);
        this.distilated = distilated;
    }

    public int getReagent() {
        if (isDistilated()) {
            return super.getReagent();
        } else {
            return super.getReagent() / 2;
        }
    }

    public boolean isDistilated() {
        return distilated;
    }
}
