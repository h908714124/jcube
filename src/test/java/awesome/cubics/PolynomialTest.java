package awesome.cubics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolynomialTest {

    private final Binomial binomial = new Binomial();

    @Test
    void testPoly() {
        Polynomial polynomial = binomial.power(Monomial.create(1, 1), Monomial.create(1, 17), 5);
        assertEquals("r^5 + 5r^3 + 10r + 10r^17 + 5r^15 + r^13", polynomial.powermod(18).toString());
        assertEquals("r^5 + 5r^3 + 10r - 10r^8 - 5r^6 - 1r^4", polynomial.powermodFlip(9).toString());
    }
}