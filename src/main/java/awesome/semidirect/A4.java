package awesome.semidirect;

import awesome.util.Suppliers;
import io.parmigiano.Permutation;

import java.util.function.Supplier;

public enum A4 {

    // K4 as a normal subgroup
    ID(Permutation.identity(), () -> A3.ID){
        @Override
        public K4 inverseBeta() {
            return K4.ID;
        }
    },
    CHOP_1(Permutation.cycle(0, 1).compose(2, 3), () -> A3.ID){
        @Override
        public K4 inverseBeta() {
            return K4.CHOP_1;
        }
    },
    CHOP_2(Permutation.cycle(0, 2).compose(1, 3), () -> A3.ID){
        @Override
        public K4 inverseBeta() {
            return K4.CHOP_2;
        }
    },
    CHOP_3(Permutation.cycle(1, 2).compose(0, 3), () -> A3.ID){
        @Override
        public K4 inverseBeta() {
            return K4.CHOP_3;
        }
    },
    // The coset containing (0,1,2)
    R0(Permutation.cycle(0, 1, 2), () -> A3.ROT1),
    R1(Permutation.cycle(0, 2, 3), () -> A3.ROT1),
    R2(Permutation.cycle(0, 3, 1), () -> A3.ROT1),
    R3(Permutation.cycle(1, 3, 2), () -> A3.ROT1),
    // The coset containing (0,2,1)
    L0(Permutation.cycle(0, 2, 1), () -> A3.ROT2),
    L1(Permutation.cycle(0, 3, 2), () -> A3.ROT2),
    L2(Permutation.cycle(0, 1, 3), () -> A3.ROT2),
    L3(Permutation.cycle(1, 2, 3), () -> A3.ROT2);

    private static final Supplier<A4[]> VALUES = Suppliers.memoize(A4::values);

    private final Permutation permutation;
    private final Supplier<A3> alpha;

    A4(Permutation permutation, Supplier<A3> alpha) {
        this.permutation = permutation;
        this.alpha = alpha;
    }

    // https://en.wikipedia.org/wiki/Semidirect_product
    public A3 alpha() {
        return alpha.get();
    }

    // https://en.wikipedia.org/wiki/Semidirect_product
    public K4 inverseBeta() {
        throw new UnsupportedOperationException();
    }

    public A4 compose(A4 other) {
        return valueOf(permutation.compose(other.permutation));
    }

    private static A4 valueOf(Permutation p) {
        for (A4 value : getValues()) {
            if (value.permutation.equals(p)) {
                return value;
            }
        }
        throw new IllegalArgumentException("no such value: " + p);
    }

    public static A4[] getValues() {
        return VALUES.get();
    }
}
