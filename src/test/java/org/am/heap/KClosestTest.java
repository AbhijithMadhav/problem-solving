package org.am.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KClosestTest {

    @Test
    void kClosest() {
        assertArrayEquals(new int[][]{{-2, 2}}, new KClosest().kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        assertArrayEquals(new int[][]{{3, 3}, {-2, 4}}, new KClosest().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));

    }
}