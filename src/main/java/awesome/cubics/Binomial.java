package awesome.cubics;

import java.util.ArrayList;
import java.util.List;

class Binomial {

    private final Monomial m1;
    private final Monomial m2;

    private Binomial(Monomial m1, Monomial m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    static Binomial create(Monomial m1, Monomial m2) {
        return new Binomial(m1, m2);
    }

    Polynomial power(int n) {
        int[] coefficients = binominalCoefficients(n);
        List<Monomial> result = new ArrayList<>(coefficients.length);
        for (int i = 0; i < coefficients.length; i++) {
            int c = coefficients[i];
            Monomial p1 = m1.raise(n - i);
            Monomial p2 = m2.raise(i);
            Monomial m = p1.multiply(p2).multiply(c);
            result.add(m);
        }
        return new Polynomial(result);
    }

    int[] binominalCoefficients(int n) {
        int[] result = new int[n + 1];
        for (int k = 0; k <= n; k++) {
            result[k] = choose(n, k);
        }
        return result;
    }

    int choose(int n, int k) {
        int denominator = faculty(k) * faculty(n - k);
        int numerator = faculty(n);
        return numerator / denominator;
    }

    int faculty(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}