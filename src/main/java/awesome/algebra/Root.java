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
}
