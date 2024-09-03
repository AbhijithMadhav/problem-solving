package org.am.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestInArrayInStreamTest {

    @Test
    void add() {
        KthLargestInStream kthLargest = new KthLargestInStream(3, new int[]{4, 5, 8, 2});
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5)); // return 5
        assertEquals(5, kthLargest.add(10)); // return 5
        assertEquals(8, kthLargest.add(9)); // return 8
        assertEquals(8, kthLargest.add(4)); // return 8
    }
}