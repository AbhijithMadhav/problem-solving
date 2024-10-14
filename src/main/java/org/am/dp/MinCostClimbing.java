package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/description/">...</a>
 */
public class MinCostClimbing {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }

    private int minCostClimbingStairs(int[] cost, int i) {
        if (i >= cost.length)
            return 0;
        return Math.min(cost[i] + cache(cost, i + 1), cost[i] + cache(cost, i + 2));
    }

    private final Map<Integer, Integer> cache = new HashMap<>();
    private int cache(int[] cost, int i) {
        if (!cache.containsKey(i))
            cache.put(i, minCostClimbingStairs(cost, i));
        return cache.get(i);
    }
}
