package org.am.interval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonOverLappingIntervalsTest {

    @Test
    void eraseOverlapIntervals() {
        assertEquals(1, new NonOverLappingIntervals().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        assertEquals(3, new NonOverLappingIntervals().eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 2}}));
        assertEquals(0, new NonOverLappingIntervals().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));

    }
}