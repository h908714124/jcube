package awesome.cubics;

import org.junit.jupiter.api.Test;

import static awesome.cubics.Binomial.binomial;
import static awesome.cubics.Monomial.monomial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolynomialTest {

    private final Binomial solution1 = binomial(monomial(1, 1), monomial(-1, 8));
    private final Binomial solution2 = binomial(monomial(1, 5), monomial(-1, 4));
    private final Binomial solution3 = binomial(monomial(1, 7), monomial(-1, 2));

    private final Polynomial one = binomial(monomial(1, 3), monomial(-1, 6)).asPolynomial();

    @Test
    void testPoly() {
        Polynomial polynomial = solution1.power(5);
        assertEquals("- 10r^8 - 5r^6 + r^5 - r^4 + 5r^3 + 10r", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testPow1() {
        Polynomial polynomial = solution1.power(1);
        assertEquals("- r^8 + r", polynomial.toString());
    }

    @Test
    void testPow3() {
        Polynomial polynomial = solution1.power(3);
        assertEquals("- 3r^8 - r^6 + r^3 + 3r", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testSolutions() {
        assertEquals(one, compute(solution1));
        assertEquals(one, compute(solution2));
        assertEquals(one, compute(solution3));
    }

    // compute r^3 - 3r, where r is an 18th root of unity
    private Polynomial compute(Binomial r) {
        Polynomial p0 = r.power(3);
        Polynomial p1 = r.multiply(3);
        return p0.subtract(p1).powermodFlip(9);
    }
}