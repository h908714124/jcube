package awesome.algebra;

public final class Root implements Expression {

    private final int den;
    private final int number;

    static Root create(int den, int number) {
        return new Root(den, number);
    }

    private Root(int den, int number) {
        if (den < 1) {
            throw new IllegalArgumentException();
        }
        this.den = den;
        this.number = number;
    }

    public Expression mult(Root r) {
        if (r.den == den && number > 0 && r.number > 0) {
            int n = r.number * number;
            long theRoot = Math.round(Math.pow(n, 1.0 / den));
            if (Math.pow(theRoot, den) == n) {
                return Expression.numeral(theRoot);
            }
        }
        throw new IllegalArgumentException();
    }
}
