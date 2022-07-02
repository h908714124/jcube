package awesome.cubics;

import java.util.List;

class Polynomial {
    
    private final List<Monomial> monomials;

    Polynomial(List<Monomial> monomials) {
        this.monomials = monomials;
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
