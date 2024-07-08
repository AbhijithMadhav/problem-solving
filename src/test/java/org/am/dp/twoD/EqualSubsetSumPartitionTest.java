package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualSubsetSumPartitionTest {

    @Test
    void canPartition() {
        assertTrue(new EqualSubsetSumPartition().canPartition(new int[]{1, 5, 11, 5, 2}));
        assertFalse(new EqualSubsetSumPartition().canPartition(new int[]{1, 5, 11, 5, 1}));
        assertTrue(new EqualSubsetSumPartition().canPartition(new int[]{35,69,8,10,56,85,20,67,39,15,57,19,80,45,12,81,92,98,25,26,51,3,31,16,30,37,55,52,61,17,30,82,52,85,84,83,98,29,79,29,99,70,97,20,42,22,44,44,65,75,70,86,97,100,45,69,91,53,88,96,65,88,92,73,16,57,34,11,64,3,92,48,98,29,39,16,47,92,22,19,50,86,78,68,52,51,70,80,2,58,79,70,91,94,23,47,81,4,18,15}));
    }
}