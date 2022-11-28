package awesome.semidirect;

import org.junit.jupiter.api.Test;

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
}