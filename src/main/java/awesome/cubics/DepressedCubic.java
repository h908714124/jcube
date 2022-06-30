package awesome.cubics;

import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;
import java.util.List;

class DepressedCubic {

    private final Complex minusHalf = Complex.valueOf(0.5).multiply(-1);

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
        Complex t = getThing().sqrt();
        Complex c1 = minusHalf.multiply(q).add(t);
        Complex c2 = minusHalf.multiply(q).subtract(t);
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

    Complex compute(Complex x) {
        return x.pow(3).add(x.multiply(p)).add(q);
    }
}
