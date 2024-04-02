package org.am.interval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {

    @Test
    void insert() {
        assertArrayEquals(
                new int[][]{{1, 5}, {6, 9}},
                new InsertInterval().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})
        );
        assertArrayEquals(
                new int[][]{{1, 2}, {3, 10}, {12, 16}},
                new InsertInterval().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})
        );

        assertArrayEquals(
                new int[][]{{1, 5}, {6, 8}},
                new InsertInterval().insert(new int[][]{{1, 5}}, new int[]{6, 8})
        );

        assertArrayEquals(
                new int[][]{{0, 0}, {1, 5}},
                new InsertInterval().insert(new int[][]{{1, 5}}, new int[]{0, 0})
        );
    }
}