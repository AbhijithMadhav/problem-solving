package org.am;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabSchedulingTest {

    @Test
    void minTime() {
        assertEquals(2, new CabScheduling().minTime(3, new int[]{1, 2}));
        assertEquals(7, new CabScheduling().minTime(10, new int[]{1, 3, 5, 7, 8}));
    }
}