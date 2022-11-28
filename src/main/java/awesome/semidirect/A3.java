package awesome.semidirect;

import java.util.function.Supplier;

public enum A3 {

    ID(() -> A4.ID),
    ROT1(() -> A4.R0),
    ROT2(() -> A4.L0);

    private final Supplier<A4> gamma;

    A3(Supplier<A4> gamma) {
        this.gamma = gamma;
    }

    // https://en.wikipedia.org/wiki/Semidirect_product
    public A4 gamma() {
        return gamma.get();
    }

    // https://en.wikipedia.org/wiki/Semidirect_product
    public S3 phi() {
        // TODO
        throw new UnsupportedOperationException();
    }
}
