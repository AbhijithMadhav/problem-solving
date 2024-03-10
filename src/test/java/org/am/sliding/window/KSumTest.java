package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KSumTest {

    @Test
    public void ksumTest() {
        Integer[] actual = KSum.ksum(new int[]{1, 2, 3, 4, 5, 6}, 3);
        assertArrayEquals(new Integer[]{6, 9, 12, 15}, actual);
        assertArrayEquals(new Integer[]{}, KSum.ksum(new int[]{}, 0));
        assertArrayEquals(new Integer[]{1}, KSum.ksum(new int[]{1}, 1));
        assertArrayEquals(new Integer[]{1, 2}, KSum.ksum(new int[]{1, 2}, 1));
        assertArrayEquals(new Integer[]{15, 20, 25, 30, 35, 40}, KSum.ksum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }
}