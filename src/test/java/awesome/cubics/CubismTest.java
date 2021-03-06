package awesome.cubics;

import org.apache.commons.math3.complex.Complex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
                .filter(r -> r.getImaginary() > 0)
                .map(r -> r.add(r.conjugate()))
                .filter(r -> cubism.compute(r).abs() < 0.01)
                .distinct().toList();
        checkSolutions(solutions);
        // what are the relations?
        System.out.println(solutions.get(0).add(solutions.get(1)).add(solutions.get(2)));
        System.out.println(solutions.get(1).divide(solutions.get(0)));
        System.out.println(solutions.get(2).divide(solutions.get(1)));
        System.out.println(solutions.get(2).divide(solutions.get(0)));
    }

    @Test
    void testExplicit() {
        Complex r = Complex.valueOf(0.9396926207859084, 0.3420201433256687);
        for (int i = 1; i <= 17; i++) {
            assertFalse(r.pow(i).subtract(Complex.ONE).abs() < 0.01);
        }
        assertTrue(r.pow(18).subtract(Complex.ONE).abs() < 0.01);
        Complex a = r.subtract(r.pow(8));
        Complex b = r.pow(5).subtract(r.pow(4));
        Complex c = r.pow(7).subtract(r.pow(2));
        System.out.println(c.pow(2).add(b));
//        System.out.println(b.pow(2).add(a));
        checkSolutions(List.of(a, b, c));
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
        assertFalse(solutions.isEmpty(), "NOTHING");
        int n = 0;
        for (Complex solution : solutions) {
            Complex result = cubism.compute(solution);
            if (result.abs() < 0.01) {
                System.out.println("SOLUTION: " + solution);
                n++;
            } else {
                System.out.println("FAIL: " + solution);
            }
        }
        assertEquals(solutions.size(), n);
    }
}