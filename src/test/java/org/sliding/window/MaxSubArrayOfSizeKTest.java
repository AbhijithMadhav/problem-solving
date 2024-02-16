package org.sliding.window;

import org.am.sliding.window.MaxSubArrayOfSizeK;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayOfSizeKTest {

    @Test
    void maxSubArrayOfSizeK() {
        assertArrayEquals(new int[]{4, 5}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{1, 2, 3, 4, 5}, 2));
        assertArrayEquals(new int[]{4, 5}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{1, 4, 5, 2, 3}, 2));
        assertArrayEquals(new int[]{4, 5}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{4, 5, 2, 1, 3}, 2));
        assertArrayEquals(new int[]{4, 5, 2}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{4, 5, 2, 1, 3}, 3));
        assertArrayEquals(new int[]{}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{4, 5, 2, 1, 3}, 6));
        assertArrayEquals(new int[]{4, 5, 2, 1, 3}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{4, 5, 2, 1, 3}, 5));
        assertArrayEquals(new int[]{2, 1, 3}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{4, -5, 2, 1, 3}, 3));
        assertArrayEquals(new int[]{-2, 1, 3}, new MaxSubArrayOfSizeK().maxSubArrayOfSizeK(new int[]{4, -5, -2, 1, 3}, 3));
    }
}