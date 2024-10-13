package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void minDistance() {
        assertEquals(3, new EditDistance().minDistance("horse", "ros"));
        assertEquals(5, new EditDistance().minDistance("intention", "execution"));
    }
}