package src.sixth.tutorial;

public class LinearFunction extends Function {

    private double a;
    private double b;

    public LinearFunction(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double f(double x) {
        return a * x + b;
    }

    @Override
    void increaseCoefficientsBy(double delta) {
        a += delta;
        b += delta;
    }

    @Override
    void decreaseCoefficientsBy(double delta) {
        a -= delta;
        b -= delta;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}