package awesome.cubics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolynomialTest {

    private final Binomial root = Binomial.create(Monomial.create(1, 1), Monomial.create(-1, 8));

    @Test
    void testPoly() {
        Polynomial polynomial = root.power(5);
        assertEquals("r^5 + 5r^3 + 10r - 10r^8 - 5r^6 - r^4", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testPow1() {
        Polynomial polynomial = root.power(1);
        assertEquals("r - r^8", polynomial.toString());
    }

    @Test
    void testPow3() {
        Polynomial polynomial = root.power(3);
        assertEquals("r^3 + 3r - 3r^8 - r^6", polynomial.powermodFlip(9).toString());
    }

    @Test
    void testSolution() {
        Polynomial p0 = root.power(3);
        Polynomial p1 = root.power(1).multiply(3);
        assertEquals("r^3 - r^6", p0.subtract(p1).powermodFlip(9).simplify().toString());
    }
}