package org.am.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

    Map<Integer, Integer> lengthByIndex = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            maxLength = Math.max(maxLength, lengthOfLIS(nums, i));
        }
        return maxLength;
    }

    // Computes length starting from 'start'
    private int lengthOfLIS(int[] nums, int start) {
        if (lengthByIndex.containsKey(start))
            return lengthByIndex.get(start);
        int length = 1;
        for (int i = start; i < nums.length - 1; i++) {
            if (nums[start] < nums[i + 1]) {
                lengthByIndex.computeIfAbsent(i + 1, key -> lengthOfLIS(nums, key));
                length = Math.max(length, lengthByIndex.get(i+ 1) + 1);
            }
        }
        return length;
    }
}
