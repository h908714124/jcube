package awesome.algebra;

public class Root {

    private final Fraction den;
    private final int number;

    private Root(int den, int number) {
        this.den = Fraction.fraction(1, den);
        this.number = number;
    }

    public static final class Builder {
        private final int den;

        private Builder(int den) {
            this.den = den;
        }

        public Root of(int number) {
            return new Root(den, number);
        }
    }

    public static Builder nthRoot(int den) {
        return new Builder(den);
    }
}
