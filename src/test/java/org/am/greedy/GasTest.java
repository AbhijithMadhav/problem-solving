package org.am.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasTest {

    @Test
    void canCompleteCircuit() {
        assertEquals(3, new Gas().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        assertEquals(-1, new Gas().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));

    }
}