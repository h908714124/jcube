package awesome.cubics;

import org.junit.jupiter.api.Test;

import static awesome.cubics.Binomial.binomial;
import static awesome.cubics.Monomial.monomial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolynomialTest {

    private final Binomial a = binomial(monomial(1, 1), monomial(-1, 8));
    private final Binomial b = binomial(monomial(1, 5), monomial(-1, 4));
    private final Binomial c = binomial(monomial(1, 7), monomial(-1, 2));

    private final Polynomial one = binomial(monomial(1, 3), monomial(-1, 6)).asPolynomial();

    @Test
    void testPoly() {
        Polynomial polynomial = a.pow(5);
        assertEquals("- 10r^8 - 5r^6 + r^5 - r^4 + 5r^3 + 10r", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testPow1() {
        Polynomial polynomial = a.pow(1);
        assertEquals("- r^8 + r", polynomial.toString());
    }

    @Test
    void testPow3() {
        Polynomial polynomial = a.pow(3);
        assertEquals("- 3r^8 - r^6 + r^3 + 3r", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testSolutions() {
        assertEquals(one, compute(a));
        assertEquals(one, compute(b));
        assertEquals(one, compute(c));
    }

    @Test
    void testStuff() {
        // a^2 + c = b^2 + a
        assertEquals(a.pow(2).add(c).powermodFlip(9), b.pow(2).add(a).powermodFlip(9));
        // b^2 + a = c^2 + b
        assertEquals(b.pow(2).add(a).powermodFlip(9), c.pow(2).add(b).powermodFlip(9));
        // c^2 + b = a^2 + c
        assertEquals(c.pow(2).add(b).powermodFlip(9), a.pow(2).add(c).powermodFlip(9));
    }

    // compute r^3 - 3r, where r is an 18th root of unity
    private Polynomial compute(Binomial r) {
        Polynomial p0 = r.pow(3);
        Polynomial p1 = r.multiply(3);
        return p0.subtract(p1).powermodFlip(9);
    }
}