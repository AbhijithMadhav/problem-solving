package org.am.dp;

import java.util.HashMap;
import java.util.Map;

public class Robber {


    private final Map<Integer, Integer> cache = new HashMap<>();
    public int rob(int[] nums) {
        int rob0 = rob(nums, 0);
        if (nums.length > 1)
            return Math.max(rob0, rob(nums, 1));
        else
            return rob0;
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
