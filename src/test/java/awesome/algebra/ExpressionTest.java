package awesome.algebra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {

    @Test
    void nthRoot() {
        Root r = Expression.nthRoot(2).of(3);
        assertEquals(Expression.numeral(3), r.mult(r));
    }
}