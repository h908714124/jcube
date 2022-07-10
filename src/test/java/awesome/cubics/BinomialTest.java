package awesome.cubics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinomialTest {

    private final Binomial binomial = Binomial.binomial(Monomial.monomial(1, 1), Monomial.monomial(-1, 8));

    @Test
    void binominalCoefficients() {
        assertArrayEquals(new int[]{1, 2, 1}, binomial.binominalCoefficients(2));
        assertArrayEquals(new int[]{1, 3, 3, 1}, binomial.binominalCoefficients(3));
        assertArrayEquals(new int[]{1, 4, 6, 4, 1}, binomial.binominalCoefficients(4));
        assertArrayEquals(new int[]{1, 5, 10, 10, 5, 1}, binomial.binominalCoefficients(5));
        assertArrayEquals(new int[]{1, 6, 15, 20, 15, 6, 1}, binomial.binominalCoefficients(6));
    }

    @Test
    void choose() {
        assertEquals(3, binomial.choose(3, 1));
        assertEquals(1, binomial.choose(4, 0));
        assertEquals(4, binomial.choose(4, 1));
        assertEquals(6, binomial.choose(4, 2));
        assertEquals(4, binomial.choose(4, 3));
        assertEquals(1, binomial.choose(4, 4));
    }

    @Test
    void faculty() {
        assertEquals(6, binomial.faculty(3));
    }
}