package awesome.cubics;

class Monomial {

    private final int coefficient;
    private final int power;

    private Monomial(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    Monomial multiply(int n) {
        return create(coefficient * n, power);
    }

    Monomial multiply(Monomial monomial) {
        return create(coefficient * monomial.coefficient, power + monomial.power);
    }

    Monomial pow(int n) {
        if (n == 0) {
            return create(1, 0);
        }
        Monomial result = this;
        for (int i = 1; i < n; i++) {
            result = result.multiply(this);
        }
        return result;
    }

    Monomial raise(int n) {
        if (n == 1) {
            return this;
        }
        return create(coefficient, power * n);
    }

    Monomial powermod(int n) {
        if (power < n) {
            return this;
        }
        return create(coefficient, power % n);
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
        return create(sign * coefficient, newPower);
    }
    
    static Monomial create(int coefficient, int power) {
        return new Monomial(coefficient, power);
    }

    @Override
    public String toString() {
        String prefix = coefficient >= 0 ? "+" : "-";
        if (power == 0) {
            return prefix + Math.abs(coefficient);
        }
        String base = prefix + " " + (coefficient == 1 ? "" : Math.abs(coefficient)) + "r";
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
        String base = prefix + (coefficient == 1 ? "" : Math.abs(coefficient)) + "r";
        if (power == 1) {
            return base;
        }
        return base + "^" + power;
    }
}
