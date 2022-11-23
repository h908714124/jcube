package awesome.algebra;

import org.apache.commons.math3.util.ArithmeticUtils;

public sealed interface Expression permits Fraction, Root, Numeral {

    final class RootBuilder {
        private final int den;

        private RootBuilder(int den) {
            this.den = den;
        }

        public Root of(int number) {
            return Root.create(den, number);
        }
    }

    static RootBuilder nthRoot(int den) {
        return new RootBuilder(den);
    }

    static Fraction fraction(int num, int den) {
        final int d = ArithmeticUtils.gcd(num, den);
        if (d > 1) {
            num /= d;
            den /= d;
        }

        // move sign to numerator.
        if (den < 0) {
            num = -num;
            den = -den;
        }
        return new Fraction(num, den);
    }

    static Numeral numeral(int n) {
        return Numeral.create(n);
    }

    static Numeral numeral(long n) {
        return numeral(Math.toIntExact(n));
    }
}
