package awesome.cubics;

import org.junit.jupiter.api.Test;

import static awesome.cubics.Binomial.binomial;
import static awesome.cubics.Monomial.monomial;
import static awesome.cubics.Polynomial.constant;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolynomialTest {

    private final Binomial a = binomial(monomial(1, 7), monomial(-1, 2));
    private final Binomial b = binomial(monomial(1, 5), monomial(-1, 4));
    private final Binomial c = binomial(monomial(1, 1), monomial(-1, 8));

    private final Polynomial one = binomial(monomial(1, 3), monomial(-1, 6)).poly();

    @Test
    void testPoly() {
        Polynomial polynomial = c.pow(5);
        assertEquals("- 10r^8 - 5r^6 + r^5 - r^4 + 5r^3 + 10r", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testPow1() {
        Polynomial polynomial = c.pow(1);
        assertEquals("- r^8 + r", polynomial.toString());
    }

    @Test
    void testPow3() {
        Polynomial polynomial = c.pow(3);
        assertEquals("- 3r^8 - r^6 + r^3 + 3r", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testSolutions() {
        assertEquals(one, compute(a));
        assertEquals(one, compute(b));
        assertEquals(one, compute(c));
    }

    @Test
    void testRelations() {
        Polynomial constant2 = constant(2);
        // a^2 + b = 2
        assertEquals(constant2, a.pow(2).add(b).powermodFlip(9));
        // b^2 + c = 2
        assertEquals(constant2, b.pow(2).add(c).powermodFlip(9));
        // c^2 + a = 2
        assertEquals(constant2, c.pow(2).add(a).powermodFlip(9));
    }

    @Test
    void factor18() {
        Polynomial f1 = monomial("x").subtract(monomial("1"));
        Polynomial f2 = monomial("x").add(monomial("1"));
        Polynomial f3 = monomial("x^2").add(monomial("x")).add(monomial("1"));
        Polynomial f6 = monomial("x^2").subtract(monomial("x")).add(monomial("1"));
        Polynomial f9 = monomial("x^6").add(monomial("x^3")).add(monomial("1"));
        Polynomial f18 = monomial("x^6").subtract(monomial("x^3")).add(monomial("1"));
        assertEquals(monomial("x^18").subtract(monomial("1")), f1.multiply(f2).multiply(f3).multiply(f6).multiply(f9).multiply(f18));
    }

    // compute r^3 - 3r, where r is an 18th root of unity
    private Polynomial compute(Binomial r) {
        Polynomial p0 = r.pow(3);
        Polynomial p1 = r.multiply(3);
        return p0.subtract(p1).powermodFlip(9);
    }
}