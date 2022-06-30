package awesome.cubics;

import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;
import java.util.List;

class DepressedCubic {

    private final Complex half = Complex.valueOf(0.5);

    private final Complex p;
    private final Complex q;

    private DepressedCubic(Complex p, Complex q) {
        this.p = p;
        this.q = q;
    }

    static DepressedCubic create(double p, double q) {
        return new DepressedCubic(Complex.valueOf(p), Complex.valueOf(q));
    }

    List<Complex> getSolutions() {
        Complex w = new Complex(5).sqrt().multiply(Complex.I).divide(2);
        Complex c1 = half.subtract(w);
        Complex c2 = half.add(w);
        List<Complex> rootsOfC1 = c1.nthRoot(3);
        List<Complex> rootsOfC2 = c2.nthRoot(3);
        List<Complex> result = new ArrayList<>();
        for (Complex r1 : rootsOfC1) {
            for (Complex r2 : rootsOfC2) {
                result.add(r1.add(r2));
            }
        }
        return result;
    }

    Complex getThing() {
        return q.pow(2).divide(4).add(p.pow(3).divide(27));
    }

    Complex getDiscriminant() {
        return p.pow(3).multiply(4).add(q.pow(2).multiply(27));
    }

    public static void main(String[] args) {
        Complex w = new Complex(5).sqrt().multiply(Complex.I).divide(2);
        System.out.println(w.pow(2));
    }

    Complex compute(Complex x) {
        return x.pow(3).add(x.multiply(p)).add(q);
    }

    double compute(double x) {
        return compute(Complex.valueOf(x)).getReal();
    }
}
