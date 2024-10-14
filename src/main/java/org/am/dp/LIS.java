package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">...</a>
 */

public class LIS {

    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            maxLength = Math.max(maxLength, lengthOfLIS(nums, i));
        }
        return maxLength;
    }

    // Computes length starting from 'start'
    private int lengthOfLIS(int[] nums, int start) {
        int length = 1;
        for (int i = start; i < nums.length - 1; i++)
            if (nums[start] < nums[i + 1])
                length = Math.max(length, cache(nums, i+ 1) + 1);
        return length;
    }

    Map<Integer, Integer> cache = new HashMap<>();
    private int cache(int[] nums, int start) {
        cache.computeIfAbsent(start, key -> lengthOfLIS(nums, key));
        return cache.get(start);
    }
}
