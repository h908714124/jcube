package awesome.semidirect;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitTest {

    @Test
    void exact() {
        for (K4 v : K4.values()) {
            assertEquals(A3.ID, v.beta().alpha());
        }
    }

    @Test
    void split() {
        for (A3 v : A3.values()) {
            assertEquals(v, v.gamma().alpha());
        }
    }

    @Test
    void automorphism() {
        Map<K4, K4> m = Map.of(
                K4.ID, K4.ID,
                K4.CHOP_1, K4.CHOP_2,
                K4.CHOP_2, K4.CHOP_1,
                K4.CHOP_3, K4.CHOP_3);
        assertEquals(S3.SWAP01, S3.valueOf(m::get));
    }
}