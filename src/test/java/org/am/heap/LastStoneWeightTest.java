package org.am.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {

    @Test
    void lastStoneWeight() {
        assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[]{2,7,4,1,8,1}));
        assertEquals(1, new LastStoneWeight().lastStoneWeight(new int[]{1}));
        assertEquals(0, new LastStoneWeight().lastStoneWeight(new int[]{1, 1}));
    }
}