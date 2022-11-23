package awesome.algebra;

import java.util.Objects;

public final class Fraction implements Expression {

    private final int numerator;
    private final int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction mult(Fraction other) {
        return Expression.fraction(numerator * other.numerator, denominator * other.denominator);
    }

    public boolean isWholeNumber() {
        return denominator == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
