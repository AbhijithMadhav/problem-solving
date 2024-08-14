package org.am.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/house-robber-ii/">...</a>
 */
public class HouseRobber2 {

    private final Map<Integer, Integer> cache = new HashMap<>();
    public int rob(int[] nums) {
        int res = rob(Arrays.copyOfRange(nums, 0, nums.length - 1), 0);
        for (int start = 1; start < nums.length; start++)
            res = Math.max(res, rob(nums, start));
        return res;
    }

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
