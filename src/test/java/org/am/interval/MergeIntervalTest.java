package org.am.interval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalTest {

    @Test
    void merge() {

        assertArrayEquals(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                new MergeInterval().merge(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}})
        );

        assertArrayEquals(
                new int[][]{{1, 5}, {6, 7}, {8, 10}, {12, 16}},
                new MergeInterval().merge(new int[][]{{1, 4}, {3, 5}, {6, 7}, {8, 10}, {12, 16}})
        );

        assertArrayEquals(
                new int[][]{{1, 6}, {8, 10}, {15, 18}},
                new MergeInterval().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})
        );
    }
}