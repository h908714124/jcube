package awesome.algebra;

public final class Numeral implements Expression {

    private final int n;

    Numeral(int n) {
        this.n = n;
    }

    public static Numeral number(int n) {
        return new Numeral(n);
    }
}
