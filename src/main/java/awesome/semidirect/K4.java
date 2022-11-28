package awesome.semidirect;

import awesome.util.Suppliers;
import io.parmigiano.Permutation;

import java.util.function.Supplier;

public enum K4 {

    ID(Permutation.identity(), () -> A4.ID),
    CHOP_1(Permutation.create(0, 1).compose(2, 3), () -> A4.CHOP_1),
    CHOP_2(Permutation.create(0, 2).compose(1, 3), () -> A4.CHOP_2),
    CHOP_3(Permutation.create(1, 2).compose(0, 3), () -> A4.CHOP_3);

    private static final Supplier<K4[]> VALUES = Suppliers.memoize(K4::values);

    private final Permutation permutation;
    private final Supplier<A4> beta;

    K4(Permutation permutation, Supplier<A4> beta) {
        this.permutation = permutation;
        this.beta = beta;
    }

    public Permutation permutation() {
        return permutation;
    }
    
    // https://en.wikipedia.org/wiki/Semidirect_product
    public A4 beta() {
        return beta.get();    
    }

    public static K4[] getValues() {
        return VALUES.get();
    }
}
