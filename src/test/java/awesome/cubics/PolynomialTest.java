package awesome.cubics;

import org.junit.jupiter.api.Test;

class PolynomialTest {

    private final Binomial binomial = new Binomial();

    @Test
    void testPoly() {
        Polynomial polynomial = binomial.power(Monomial.create(1, 1), Monomial.create(1, 17), 5);
        System.out.println(polynomial.toString());
    }
}