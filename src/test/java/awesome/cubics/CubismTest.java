package awesome.cubics;

import org.apache.commons.math3.complex.Complex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class CubismTest {

    private final DepressedCubic cubism = DepressedCubic.create(-3, -1);

    @Test
    void testGetSolution() {
        List<Complex> solutions = cubism.getSolutions();
        checkSolutions(solutions);
    }

    @Test
    void testSolutions() {
        Complex t = Complex.I.multiply(Complex.valueOf(3).sqrt()).divide(2);
        Complex minusHalf = Complex.valueOf(0.5).multiply(-1);
        Complex c1 = minusHalf.multiply(-1).add(t);
        Complex c2 = minusHalf.multiply(-1).subtract(t);
        List<Complex> rootsOfC1 = c1.nthRoot(3);
        List<Complex> rootsOfC2 = c2.nthRoot(3);
        List<Complex> solutions = new ArrayList<>();
        solutions.add(rootsOfC1.get(0).add(rootsOfC2.get(0)));
        solutions.add(rootsOfC1.get(1).add(rootsOfC2.get(2)));
        solutions.add(rootsOfC1.get(2).add(rootsOfC2.get(1)));
        checkSolutions(solutions);
    }

    @Test
    void testSimple() {
        List<Complex> rootsOfC1 = firstSummand();
        List<Complex> rootsOfC2 = secondSummand();
        List<Complex> solutions = new ArrayList<>();
        Complex ra0 = rootsOfC1.get(0).divide(thirdRootOfTwo());
        Complex ra1 = rootsOfC2.get(0).divide(thirdRootOfTwo());
        solutions.add(ra0.add(ra1));
        Complex rb0 = rootsOfC1.get(1).divide(thirdRootOfTwo());
        Complex rb1 = rootsOfC2.get(2).divide(thirdRootOfTwo());
        solutions.add(rb0.add(rb1));
        Complex rc0 = rootsOfC1.get(2).divide(thirdRootOfTwo());
        Complex rc1 = rootsOfC2.get(1).divide(thirdRootOfTwo());
        solutions.add(rc0.add(rc1));
        checkSolutions(solutions);
    }

    @Test
    void rootsAreSolutions() {
        List<Complex> roots = Complex.valueOf(-1).nthRoot(9);
        List<Complex> solutions = roots.stream()
                .map(r -> r.add(r.conjugate()))
                .filter(r -> cubism.compute(r.add(r.conjugate())).abs() < 0.01)
                .distinct().collect(Collectors.toList());
        checkSolutions(solutions);
    }

    private List<Complex> firstSummand() {
        return Complex.ONE.add(Complex.I.multiply(Complex.valueOf(3).sqrt())).nthRoot(3);
    }

    private List<Complex> secondSummand() {
        return Complex.ONE.subtract(Complex.I.multiply(Complex.valueOf(3).sqrt())).nthRoot(3);
    }

    private Complex thirdRootOfTwo() {
        return Complex.valueOf(2).nthRoot(3).get(0);
    }

    private void checkSolutions(List<Complex> solutions) {
        for (Complex solution : solutions) {
            Complex result = cubism.compute(solution);
            Assertions.assertTrue(result.abs() < 0.01);
            System.out.println("SOLUTION: " + solution);
        }
    }
}