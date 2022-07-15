package awesome.cubics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonomialTest {

    @Test
    void testRaise() {
        Monomial m = Monomial.monomial(-1, 4).raise(3);
        assertEquals("- x^12", m.toString());
    }
}
