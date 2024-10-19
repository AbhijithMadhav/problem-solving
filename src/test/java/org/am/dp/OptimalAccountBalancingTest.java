package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptimalAccountBalancingTest {

    @Test
    void minTransactions() {
        assertEquals(2, new OptimalAccountBalancing().minTransactions(3, new int[][]{{0,1,10}, {2,0,5}}));
        assertEquals(1, new OptimalAccountBalancing().minTransactions(3, new int[][]{{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}}));
        assertEquals(1, new OptimalAccountBalancing().minTransactions(3, new int[][]{{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}}));
    }
}