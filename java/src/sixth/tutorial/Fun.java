package src.sixth.tutorial;

import src.sixth.tutorial.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.Collections;

public interface Fun {

    double f(double x);

    static double minimum(Fun func, double a, double b, double alpha) {
        if (a >= b) {
            throw new InvalidDataException("A must be greater than B.");
        }
        ArrayList<Double> result = new ArrayList<>();
        while (a <= b) {
            result.add(func.f(a));
            a += alpha;
        }
        return Collections.min(result);
    }
}