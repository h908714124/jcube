package awesome.cubics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

record Polynomial(List<Monomial> monomials) {

    Polynomial add(Polynomial other) {
        List<Monomial> result = new ArrayList<>(monomials.size() + other.monomials.size());
        result.addAll(monomials);
        result.addAll(other.monomials);
        return new Polynomial(result);
    }

    Polynomial subtract(Polynomial other) {
        return add(other.multiply(-1));
    }

    Polynomial simplify() {
        return new Polynomial(simplifyInternal());
    }

    private List<Monomial> simplifyInternal() {
        Map<Integer, Optional<Monomial>> m = monomials.stream().collect(groupingBy(
                Monomial::power,
                LinkedHashMap::new,
                reducing(Monomial::add)));
        List<Monomial> result = new ArrayList<>(monomials.size());
        for (Optional<Monomial> monomial : m.values()) {
            Monomial mon = monomial.orElseThrow();
            if (!mon.isZero()) {
                result.add(mon);
            }
        }
        return result;
    }

    Polynomial multiply(int n) {
        return new Polynomial(monomials.stream().map(m -> m.multiply(n)).toList());
    }

    // r^n == 1
    Polynomial powermod(int n) {
        return new Polynomial(monomials.stream().map(m -> m.powermod(n)).toList());
    }

    // r^n == -1
    Polynomial powermodFlip(int n) {
        return new Polynomial(monomials.stream().map(m -> m.powermodFlip(n)).toList());
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
