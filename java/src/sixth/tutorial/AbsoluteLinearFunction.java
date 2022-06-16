package src.sixth.tutorial;

public class AbsoluteLinearFunction extends LinearFunction {

    public AbsoluteLinearFunction(double a, double b) {
        super(a, b);
    }

    @Override
    public double f(double x) {
        double y = getA() * x + getB();
        if (y < 0) {
            y *= (-1);
        }
        return y;
    }
}