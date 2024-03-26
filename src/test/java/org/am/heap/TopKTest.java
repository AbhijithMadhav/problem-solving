package org.am.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKTest {

    @Test
    void topKFrequent() {
        assertArrayEquals(new int[] {1, 2}, new TopK().topKFrequent(new int[]{4, 6, 3, 2, 1, 2, 3, 1, 1, 2}, 2));
    }
}