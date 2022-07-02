package awesome.cubics;

import java.util.List;
import java.util.stream.Collectors;

class Polynomial {

    private final List<Monomial> monomials;

    Polynomial(List<Monomial> monomials) {
        this.monomials = monomials;
    }

    // r^n == 1
    Polynomial powermod(int n) {
        return new Polynomial(monomials.stream().map(m -> m.powermod(n)).collect(Collectors.toList()));
    }

    // r^n == -1
    Polynomial powermodFlip(int n) {
        return new Polynomial(monomials.stream().map(m -> m.powermodFlip(n)).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!monomials.isEmpty()) {
            sb.append(monomials.get(0).altString());
        }
        for (int i = 1; i < monomials.size(); i++) {
            Monomial monomial = monomials.get(i);
            sb.append(" ");
            sb.append(monomial.toString());
        }
        return sb.toString();
    }
}
