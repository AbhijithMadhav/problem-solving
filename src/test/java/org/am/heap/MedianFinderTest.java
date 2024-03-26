package org.am.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void findMedian() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertEquals(1, medianFinder.findMedian());
        medianFinder.addNum(100);
        assertEquals((double)101/2, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(3, medianFinder.findMedian());
        medianFinder.addNum(9);
        assertEquals(6, medianFinder.findMedian());
    }

    @Test
    void findMedian1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertEquals(1, medianFinder.findMedian());
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2, medianFinder.findMedian());
    }
}