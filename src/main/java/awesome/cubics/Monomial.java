package awesome.cubics;

import java.util.Comparator;

import static awesome.cubics.Preconditions.checkState;

record Monomial(int coefficient, int power) implements Comparable<Monomial> {

    private static final Comparator<Monomial> COMP = Comparator.comparingInt(Monomial::power).reversed()
            .thenComparing(Monomial::coefficient);

    Monomial multiply(int n) {
        return monomial(coefficient * n, power);
    }

    Monomial multiply(Monomial monomial) {
        return monomial(coefficient * monomial.coefficient, power + monomial.power);
    }

    Monomial pow(int n) {
        if (n == 0) {
            return monomial(1, 0);
        }
        Monomial result = this;
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return result;
    }

    Monomial raise(int n) {
        if (n == 0) {
            return monomial(1, 0);
        }
        if (n == 1) {
            return this;
        }
        int newCoefficient = coefficient > 0 ? coefficient : coefficient * (n % 2 == 0 ? -1 : 1);
        return monomial(newCoefficient, power * n);
    }

    Monomial powermod(int n) {
        if (power < n) {
            return this;
        }
        return monomial(coefficient, power % n);
    }

    Monomial powermodFlip(int n) {
        if (power < n) {
            return this;
        }
        int sign = 1;
        int newPower = power;
        while (newPower >= n) {
            newPower -= n;
            sign *= -1;
        }
        return monomial(sign * coefficient, newPower);
    }

    static Monomial monomial(int coefficient, int power) {
        return new Monomial(coefficient, power);
    }

    boolean cancels(Monomial other) {
        return power == other.power && coefficient + other.coefficient == 0;
    }

    @Override
    public String toString() {
        String prefix = coefficient >= 0 ? "+" : "-";
        if (power == 0) {
            return prefix + Math.abs(coefficient);
        }
        String base = prefix + " " + (Math.abs(coefficient) == 1 ? "" : Math.abs(coefficient)) + "r";
        if (power == 1) {
            return base;
        }
        return base + "^" + power;
    }

    String altString() {
        if (coefficient == 0) {
            return "";
        }
        String prefix = coefficient >= 0 ? "" : "- ";
        String base = prefix + (Math.abs(coefficient) == 1 ? "" : Math.abs(coefficient)) + "r";
        if (power == 1) {
            return base;
        }
        return base + "^" + power;
    }

    boolean isZero() {
        return coefficient == 0;
    }

    Monomial add(Monomial other) {
        checkState(this.power == other.power, "power mismatch");
        return new Monomial(this.coefficient + other.coefficient, this.power);
    }

    @Override
    public int compareTo(Monomial o) {
        return COMP.compare(this, o);
    }
}
