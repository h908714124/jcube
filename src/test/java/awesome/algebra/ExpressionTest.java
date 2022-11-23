package awesome.algebra;

import org.junit.jupiter.api.Test;

import static awesome.algebra.Expression.nthRoot;
import static awesome.algebra.Expression.numeral;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {

    @Test
    void multiplyRoots() {
        Root r = nthRoot(2).of(3);
        assertEquals(numeral(3), r.mult(r));
    }
}