package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/house-robber/">...</a>
 */
public class HouseRobber {

    public int rob(int[] nums) {
        return Math.max(rob(nums, 0), nums.length > 1 ? rob(nums, 1) : 0);
    }

    // rob starting at nums[start]
    private int rob(int[] nums, int start) {
        int max = 0;
        for (int i = start + 2; i < nums.length; i++)
            max =  Math.max(max, cache(nums, i));
        return nums[start] + max;
    }

    private final Map<Integer, Integer> cache = new HashMap<>();
    private int cache(int[] nums, int start) {
        if (!cache.containsKey(start))
            cache.put(start, rob(nums, start));
        return cache.get(start);
    }
}
