package src.sixth.tutorial;

public class SquareFunction extends Function {

    private double a;
    private double b;
    private double c;

    @Override
    void increaseCoefficientsBy(double delta) {
        a += delta;
        c += delta;
        a += delta;
    }

    @Override
    void decreaseCoefficientsBy(double delta) {
        a -= delta;
        c -= delta;
        a -= delta;
    }

    @Override
    public double f(double x) {
        return a * Math.sqrt((int) x) + (b * x) + c;
    }

    public SquareFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}