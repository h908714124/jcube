package awesome.algebra;

import java.util.Objects;

public final class Numeral implements Expression {

    private final int n;

    private Numeral(int n) {
        this.n = n;
    }

    static Numeral create(int n) {
        return new Numeral(n);
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numeral numeral = (Numeral) o;
        return n == numeral.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
