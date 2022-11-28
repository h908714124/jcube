package awesome.semidirect;

import java.util.function.Function;
import java.util.function.Supplier;

public enum A3 {

    ID(() -> A4.ID){
        @Override
        public A3 invert() {
            return ID;
        }
    },
    ROT1(() -> A4.R0){
        @Override
        public A3 invert() {
            return ROT2;
        }
    },
    ROT2(() -> A4.L0){
        @Override
        public A3 invert() {
            return ROT1;
        }
    };

    private final Supplier<A4> gamma;

    A3(Supplier<A4> gamma) {
        this.gamma = gamma;
    }

    // https://en.wikipedia.org/wiki/Semidirect_product
    public A4 gamma() {
        return gamma.get();
    }

    public abstract A3 invert();

    // https://en.wikipedia.org/wiki/Semidirect_product
    public S3 phi() {
        Function<K4, K4> f = n -> gamma().compose(n.beta().compose(invert().gamma())).inverseBeta();
        return S3.valueOf(f);
    }
}
