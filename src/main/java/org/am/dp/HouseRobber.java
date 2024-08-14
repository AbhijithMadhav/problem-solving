package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/house-robber/">...</a>
 */
public class HouseRobber {


    private final Map<Integer, Integer> cache = new HashMap<>();
    public int rob(int[] nums) {
        int res = 0;
        //
        for (int start = 0; start < nums.length; start++)
            res = Math.max(res, rob(nums, start));
        return res;
    }

    // rob starting at nums[start]
    private int rob(int[] nums, int start) {
        if (cache.containsKey(start))
            return cache.get(start);
        int max = 0;
        for (int i = start + 2; i < nums.length; i++) {
            max =  Math.max(max, rob(nums, i));
        }
        int result = nums[start] + max;
        cache.put(start, result);
        return result;
    }
}
