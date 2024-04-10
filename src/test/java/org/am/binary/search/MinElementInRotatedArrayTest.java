package org.am.binary.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinElementInRotatedArrayTest {

    @Test
    void findMin() {
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {9, 1, 2, 3, 4, 5, 6, 7, 8}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {8, 9, 1, 2, 3, 4, 5, 6, 7}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {7, 8, 9, 1, 2, 3, 4, 5, 6}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {6, 7, 8, 9, 1, 2, 3, 4, 5}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {5, 6, 7, 8, 9, 1, 2, 3, 4}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {4, 5, 6, 7, 8, 9, 1, 2, 3}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {3, 4, 5, 6, 7, 8, 8, 1, 2}));
        assertEquals(1, new MinElementInRotatedArray().findMin(new int[] {2, 3, 4, 5, 6, 7, 8, 9, 1}));
    }
}