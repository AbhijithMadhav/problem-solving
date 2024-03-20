package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    @Test
    void maxSubArray() {
        MaxSubArray maxSubArray = new MaxSubArray();
        assertEquals(6, maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(23, maxSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        assertEquals(5, maxSubArray.maxSubArray(new int[]{5}));
        assertEquals(-1, maxSubArray.maxSubArray(new int[]{-1}));
        assertEquals(-1, maxSubArray.maxSubArray(new int[]{-1, -4, -5}));
    }
}