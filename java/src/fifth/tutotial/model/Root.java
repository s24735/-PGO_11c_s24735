package src.fifth.tutotial.model;

public class Root extends Plants {

    public Root(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    public int getReagent() {
        return super.getReagent() / 2;
    }
}
