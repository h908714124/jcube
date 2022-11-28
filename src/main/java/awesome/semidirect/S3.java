package awesome.semidirect;

import awesome.util.Suppliers;
import io.parmigiano.Permutation;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

// The automorphism group of K4 is S3.
// https://en.wikipedia.org/wiki/Klein_four-group
public enum S3 {

    ID(Permutation.identity()),
    ROT1(Permutation.create(1, 2, 3)),
    ROT2(Permutation.create(1, 3, 2)),
    SWAP01(Permutation.create(1, 2)),
    SWAP12(Permutation.create(2, 3)),
    SWAP02(Permutation.create(1, 3));

    private static final Supplier<S3[]> VALUES = Suppliers.memoize(S3::values);

    private final Permutation permutation;

    S3(Permutation permutation) {
        this.permutation = permutation;
    }

    public Permutation permutation() {
        return permutation;
    }

    public K4 apply(K4 v) {
        return K4.getValues()[permutation.apply(v.ordinal())];
    }

    public static S3[] getValues() {
        return VALUES.get();
    }

    public static S3 valueOf(Function<K4, K4> f) {
        for (S3 value : getValues()) {
            if (Arrays.stream(K4.getValues())
                    .allMatch(k4 -> f.apply(k4) == value.apply(k4))) {
                return value;
            }
        }
        throw new IllegalArgumentException("no match");
    }
}
