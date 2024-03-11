package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestSubArrayWithSumGreaterThanKTest {

    @Test
    void smallestSubArrayWithSumK() {
        SmallestSubArrayWithSumGreaterThanK testObject = new SmallestSubArrayWithSumGreaterThanK();
        assertEquals(1, testObject.minSubArrayLen(5, new int[]{1, 2, 3, 4, 5}));
        assertEquals(3, testObject.minSubArrayLen(10, new int[]{1, 2, 3, 4, 5}));
        assertEquals(2, testObject.minSubArrayLen(6, new int[]{1, 2, 3, 4, 5}));
        assertEquals(2, testObject.minSubArrayLen(6, new int[]{1, 2, 3, 4, -5}));
        assertEquals(0, testObject.minSubArrayLen(6, new int[]{1, 2, -3, 4, -5}));
        assertEquals(2, testObject.minSubArrayLen(3, new int[]{1, 2, -3, 4, -5}));
    }
}