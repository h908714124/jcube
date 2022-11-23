package awesome.algebra;

public class Root {

    private final Fraction exponent;
    private final int number;

    private Root(Fraction exponent, int number) {
        this.exponent = exponent;
        this.number = number;
    }

    public static final class Builder {
        private final int exponent;

        private Builder(int exponent) {
            this.exponent = exponent;
        }

        public Root of(int number) {
            return new Root(Fraction.fraction(1, exponent), number);
        }
    }

    public static Builder nthRoot(int exponent) {
        return new Builder(exponent);
    }
}
