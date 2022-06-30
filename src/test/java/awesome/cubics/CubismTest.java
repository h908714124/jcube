package awesome.cubics;

import org.apache.commons.math3.complex.Complex;
import org.junit.jupiter.api.Test;

import java.util.List;

class CubismTest {

    private final DepressedCubic cubism = DepressedCubic.create(-3, -1);

    @Test
    void discriminant() {
        System.out.println(cubism.getDiscriminant());
    }

    @Test
    void testGetSolution() {
        List<Complex> solutions = cubism.getSolutions();
        for (Complex solution : solutions) {
            Complex result = cubism.compute(solution);
            if (result.abs() < 0.01) {
                System.out.println("SOLUTION: " + solution);
            }
        }
    }
}