package org.am.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RottingOrangesTest {

    @Test
    void orangesRotting() {
        assertEquals(2, new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}}));
        assertEquals(1, new RottingOranges().orangesRotting(new int[][]{{2}, {1}}));
        assertEquals(4, new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        assertEquals(0, new RottingOranges().orangesRotting(new int[][]{{0, 2}}));
    }
}