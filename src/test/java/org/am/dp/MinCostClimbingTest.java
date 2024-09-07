package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingTest {

    @Test
    void minCostClimbingStairs() {
        assertEquals(15, new MinCostClimbing().minCostClimbingStairs(new int[]{10,15,20}));
        assertEquals(6, new MinCostClimbing().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}