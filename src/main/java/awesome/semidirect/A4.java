package awesome.semidirect;

import io.parmigiano.Permutation;

import java.util.function.Supplier;

public enum A4 {

    // K4 as a normal subgroup
    ID(Permutation.identity(), () -> A3.ID),
    CHOP_1(Permutation.create(0, 1).compose(2, 3), () -> A3.ID),
    CHOP_2(Permutation.create(0, 2).compose(1, 3), () -> A3.ID),
    CHOP_3(Permutation.create(1, 2).compose(0, 3), () -> A3.ID),
    // The coset containing (0,1,2)
    R0(Permutation.create(0, 1, 2), () -> A3.ROT1),
    R1(Permutation.create(0, 2, 3), () -> A3.ROT1),
    R2(Permutation.create(0, 3, 1), () -> A3.ROT1),
    R3(Permutation.create(1, 3, 2), () -> A3.ROT1),
    // The coset containing (0,2,1)
    L0(Permutation.create(0, 2, 1), () -> A3.ROT2),
    L1(Permutation.create(0, 3, 2), () -> A3.ROT2),
    L2(Permutation.create(0, 1, 3), () -> A3.ROT2),
    L3(Permutation.create(1, 2, 3), () -> A3.ROT2);

    private final Permutation permutation;
    private final Supplier<A3> alpha;

    A4(Permutation permutation, Supplier<A3> alpha) {
        this.permutation = permutation;
        this.alpha = alpha;
    }

    public Permutation permutation() {
        return permutation;
    }

    // https://en.wikipedia.org/wiki/Semidirect_product
    public A3 alpha() {
        return alpha.get();
    }
}
