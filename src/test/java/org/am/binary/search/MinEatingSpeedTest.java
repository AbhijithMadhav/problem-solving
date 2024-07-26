package org.am.binary.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinEatingSpeedTest {

    @Test
    void minEatingSpeed() {
        assertEquals(3, new MinEatingSpeed().minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
        assertEquals(4, new MinEatingSpeed().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}