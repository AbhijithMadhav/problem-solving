package org.sliding.window;

import org.am.sliding.window.SmallestSubArrayWithSumGreaterThanK;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestSubArrayWithSumGreaterThanKTest {

    @Test
    void smallestSubArrayWithSumK() {
        SmallestSubArrayWithSumGreaterThanK testObject = new SmallestSubArrayWithSumGreaterThanK();
        assertArrayEquals(new int[]{}, testObject.smallestSubArrayWithSumK(new int[]{}, 1));
        assertArrayEquals(new int[]{5}, testObject.smallestSubArrayWithSumK(new int[]{1, 2, 3, 4, 5}, 5));
        assertArrayEquals(new int[]{3, 4, 5}, testObject.smallestSubArrayWithSumK(new int[]{1, 2, 3, 4, 5}, 10));
        assertArrayEquals(new int[]{3, 4}, testObject.smallestSubArrayWithSumK(new int[]{1, 2, 3, 4, 5}, 6));
        assertArrayEquals(new int[]{3, 4}, testObject.smallestSubArrayWithSumK(new int[]{1, 2, 3, 4, -5}, 6));
        assertArrayEquals(new int[]{}, testObject.smallestSubArrayWithSumK(new int[]{1, 2, -3, 4, -5}, 6));
        assertArrayEquals(new int[]{1, 2}, testObject.smallestSubArrayWithSumK(new int[]{1, 2, -3, 4, -5}, 3));

    }
}