package awesome.semidirect;

import io.parmigiano.Permutation;

// The automorphism group of K4 is S3.
public enum S3 {

    ID(Permutation.identity()),
    ROT1(Permutation.create(0, 1, 2)),
    ROT2(Permutation.create(0, 1, 2)),
    SWAP01(Permutation.create(0, 1)),
    SWAP12(Permutation.create(1, 2)),
    SWAP02(Permutation.create(0, 2));

    private final Permutation permutation;

    S3(Permutation permutation) {
        this.permutation = permutation;
    }

    public Permutation permutation() {
        return permutation;
    }
}
