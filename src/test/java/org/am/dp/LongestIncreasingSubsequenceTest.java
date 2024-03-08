package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    @Test
    void lengthOfLIS() {
        assertEquals(0, lis().lengthOfLIS(new int[]{}));
        assertEquals(1, lis().lengthOfLIS(new int[] {10}));
        assertEquals(1, lis().lengthOfLIS(new int[] {1, 1, 1}));
        assertEquals(1, lis().lengthOfLIS(new int[] {10, 9, 8, 7, 3, 2}));
        assertEquals(4, lis().lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(5, lis().lengthOfLIS(new int[] {1, 2, 3, 4, 5}));
        assertEquals(5, lis().lengthOfLIS(new int[] {2, 3, 1, 2, 1, 3, 4, 5}));
    }

    private static LongestIncreasingSubsequence lis() {
        return new LongestIncreasingSubsequence();
    }
}