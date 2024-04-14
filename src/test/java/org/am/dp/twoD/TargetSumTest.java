package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetSumTest {

    @Test
    void findTargetSumWays() {
        assertEquals(5, new TargetSum().findTargetSumWays(new int[]{ 1, 1, 1, 1, 1}, 3));
    }
}