package awesome.algebra;

import org.apache.commons.math3.util.ArithmeticUtils;

public class Fraction {

    private final int numerator;
    private final int denominator;

    private Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction fraction(int num, int den) {
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

    public static Fraction wholeNumber(int numerator) {
        return fraction(numerator, 1);
    }

    public Fraction mult(Fraction other) {
        return fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public boolean isWholeNumber() {
        return denominator == 1;
    }
}
