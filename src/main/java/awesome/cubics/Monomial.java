package awesome.cubics;

import java.util.Comparator;
import java.util.List;

import static awesome.cubics.Preconditions.checkState;
import static java.lang.Integer.parseInt;

record Monomial(int coefficient, int power) implements Comparable<Monomial> {

    private static final Comparator<Monomial> COMP = Comparator.comparingInt(Monomial::power).reversed()
            .thenComparing(Monomial::coefficient);

    Monomial multiply(int n) {
        return monomial(coefficient * n, power);
    }

    Monomial multiply(Monomial monomial) {
        return monomial(coefficient * monomial.coefficient, power + monomial.power);
    }

    Polynomial poly() {
        return Polynomial.create(List.of(this));
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

    static Polynomial monomial(String s) {
        if (s.contains("^")) {
            String[] tokens = s.split("[\\^]", -1);
            return new Monomial(getCoefficient(tokens[0]), parseInt(tokens[1])).poly();
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c == '-' || c == ' ' || Character.isDigit(c))) {
                return new Monomial(getCoefficient(s), 1).poly();
            }
        }
        return new Monomial(getCoefficient(s), 0).poly();
    }

    private static int getCoefficient(String token) {
        StringBuilder sb = new StringBuilder();
        char[] chars = token.toCharArray();
        for (char c : chars) {
            if (c == '-' || c == ' ' || Character.isDigit(c)) {
                if (c != ' ') {
                    sb.append(c);
                }
            } else {
                break;
            } 
        }
        if (sb.length() == 0) {
            return 1;
        }
        String result = sb.toString();
        if (result.equals("-")) {
            return -1;
        }
        return parseInt(result);
    }

    @Override
    public String toString() {
        String prefix = coefficient >= 0 ? "+" : "-";
        if (power == 0) {
            return prefix + Math.abs(coefficient);
        }
        String base = prefix + " " + (Math.abs(coefficient) == 1 ? "" : Math.abs(coefficient)) + "x";
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
        if (power == 0) {
            return prefix + Math.abs(coefficient);
        }
        String base = prefix + (Math.abs(coefficient) == 1 ? "" : Math.abs(coefficient)) + "x";
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
