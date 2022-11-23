package awesome.algebra;

public class Fraction {

    private final int numerator;
    private final int denominator;

    private Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction fraction(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }

    public static Fraction wholeNumber(int numerator) {
        return new Fraction(numerator, 1);
    }

    public Fraction mult(Fraction other) {
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public Fraction simplify() {
        if (numerator == denominator) {
            return fraction(1, 1);
        }
        return this;
    }

    public boolean isWholeNumber() {
        return denominator == 1;
    }
}
